class Solution {

    // int BruteForce(int[] nums) {
    //     int n = nums.length;
        
    //     int max = Integer.MIN_VALUE;
    //     for(int k = 0; k < n; k++) {
    //         for(int i = k; i < n; i++) {
    //             int mul = 1;
    //             for(int j = k; j <= i; j++) {
    //                 mul *= nums[j];
    //             }
    //             max = Math.max(max,mul);
    //         }
    //     }
    //     return max;
    // }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxi = Integer.MIN_VALUE;
        int pref = 1;
        int suff = 1;

        for(int i = 0; i < n; i++) {
            pref *= nums[i];
            suff *= nums[n-i-1];
            maxi = Math.max(maxi, Math.max(pref, suff));
            if(nums[i] == 0) pref = 1;
            if(nums[n-i-1] == 0) suff = 1;
        }
        return maxi;
    }
}