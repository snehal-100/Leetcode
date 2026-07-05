class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        Map<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int more = target - nums[i];
            if (secondMap.containsKey(more)) {
                return new int[] { secondMap.get(more), i };
            }
            secondMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}