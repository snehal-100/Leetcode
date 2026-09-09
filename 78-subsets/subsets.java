class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int total=1<<n;
        List<List<Integer>> ans=new ArrayList<>();
        for(int m=0;m<total;m++){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((m & (1<<i))!=0){
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}