class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        for(int i = 0; i < n1; i++) {
            int idx = 0;
            for(int k = 0; k < n2; k++) {
                if(nums1[i] == nums2[k]) {
                    idx = k;
                    break;
                }
            }
            boolean flag = true;
            for(int j = idx+1; j < n2; j++) {
                if(nums2[j] > nums1[i]) {
                    flag = false;
                    ans[i] = nums2[j];
                    break;
                }
            }
            if(flag) ans[i] = -1;
        }
        return ans;
    }
}