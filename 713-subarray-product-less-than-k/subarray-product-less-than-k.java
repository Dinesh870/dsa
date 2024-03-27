class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        // Brute force
        // for(int i = 0; i < nums.length; i++) {
        //     int mul = 1;
        //     for(int j = i; j < nums.length; j++) {
        //         mul *= nums[j];
        //         if(mul < k) count++;
        //          else break;
        //     }
        // }
        // return count;

        // method 2: using sliding window
        if(k<=1) return 0;

        int left = 0, right = 0;
        int n = nums.length;
        int prod = 1;
        
        right = 0;
        while(right < n) {
            prod *= nums[right];
            while(prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += (right-left+1);
            right++;
        }
        return count;
    }
}