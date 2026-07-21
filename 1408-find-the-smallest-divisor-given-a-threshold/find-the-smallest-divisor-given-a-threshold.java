class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int num:nums){
            high=Math.max(high,num);
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(sumOfD(nums,mid)<=threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int sumOfD(int[]nums,int div){
        int sum=0;
        for(int num:nums){
            sum+=(num+div-1)/div;
        }
        return sum;
    }
}