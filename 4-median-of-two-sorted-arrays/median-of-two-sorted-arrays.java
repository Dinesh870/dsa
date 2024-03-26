class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int l = m+n;
        int[] nums = new int[l];
        int k = 0;

        for(int i = 0; i < n; i++){
            nums[i] = nums1[i];
        }
        for(int i = n ;i <l; i++){
            nums[i] = nums2[k++];
        }

        Arrays.sort(nums);
        if(l%2 == 0){
            double ans = (double)(nums[l/2]+nums[(l/2)-1])/2;
            return ans;
        }
        return (double)(nums[l/2]);
    }
}