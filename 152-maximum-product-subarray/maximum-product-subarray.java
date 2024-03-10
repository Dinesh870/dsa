class Solution {

    // int fun(int[] nums, int i, int j) {

    //     int suff = nums[i] * fun(nums, i+1, j);
    //     int pref = nums[j] * fun(nums, i, j-1);
    // }

    int BruteForce(int[] nums) {
        int n = nums.length;
        
        int max = Integer.MIN_VALUE;
        for(int k = 0; k < n; k++) {
            for(int i = k; i < n; i++) {
                int mul = 1;
                for(int j = k; j <= i; j++) {
                    mul *= nums[j];
                }
                max = Math.max(max,mul);
            }
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxi = -1000000;
        int pref = 1;

        for(int i = 0; i < n; i++) {
            pref *= nums[i];
            maxi = Math.max(maxi, pref);
            if(nums[i] == 0) pref = 1;
        }
        int suff = 1;
        for(int i = n-1; i >=0; i--) {
            suff *= nums[i];
            maxi = Math.max(maxi, suff);
            if(nums[i] == 0) suff = 1;
        }
        return maxi;
    }
}