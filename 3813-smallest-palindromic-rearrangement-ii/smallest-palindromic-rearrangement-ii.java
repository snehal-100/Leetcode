class Solution {
    static final long LIMIT = 1000000000000000000L;
    long[] fact;
    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        String mid = "";
        int half = 0;
        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1)
                mid = String.valueOf((char) ('a' + i));
            cnt[i] /= 2;
            half += cnt[i];
        }
        fact = new long[half + 1];
        fact[0] = 1;
        for (int i = 1; i <= half; i++) {
            if (fact[i - 1] > LIMIT / i)
                fact[i] = LIMIT;
            else
                fact[i] = fact[i - 1] * i;
        }
        if (countWays(cnt) < k) return "";
        StringBuilder left = new StringBuilder();
        while (left.length() < half) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == 0) continue;
                cnt[i]--;
                long ways = countWays(cnt);
                if (ways >= k) {
                    left.append((char) ('a' + i));
                    break;
                }
                k -= ways;
                cnt[i]++;
            }
        }
        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }
    private long countWays(int[] cnt) {
        int total = 0;
        for (int x : cnt) total += x;

        long res = 1;
        int rem = total;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            res = mulCap(res, nCr(rem, cnt[i]));
            rem -= cnt[i];
            if (res >= LIMIT) return LIMIT;
        }
        return res;
    }
    private long nCr(int n, int r) {
        if (r > n) return 0;
        r = Math.min(r, n - r);

        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= LIMIT) return LIMIT;
        }
        return ans;
    }
    private long mulCap(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a >= LIMIT || b >= LIMIT) return LIMIT;
        if (a > LIMIT / b) return LIMIT;
        return a * b;
    }
}