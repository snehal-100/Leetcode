class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int x : bloomDay) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }
        int ans=high;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)==true){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean possible(int[]bloomDay,int day,int m,int k){
        int count=0;
        int noOfB=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                noOfB+=(count/k);
                count=0;
            }
        }
        noOfB+=(count/k);
        if(noOfB>=m){
            return true;
        }
        else{
            return false;
        }
    }
}