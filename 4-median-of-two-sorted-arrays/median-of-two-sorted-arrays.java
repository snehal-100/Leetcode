class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m+n;
        int []merge = new int[total];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                merge[k++]=nums1[i++];
            }
            else{
                merge[k++]=nums2[j++];
            }
        }
        while(i<m){
            merge[k++]=nums1[i++];
        }
        while(j<n){
            merge[k++]=nums2[j++];
        }
        if(total%2==0){
            return (merge[total/2-1]+merge[total/2])/2.0;
        }
        else{
            return merge[total/2];
        }
    }
}