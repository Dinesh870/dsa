class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int n = nums.length;
        int left = 0, right = 0;
        int ans = 0;

        while(right < n) {
            if(nums[right] == 0) {
                if(zeros < k) {
                    zeros++;
                } else {
                    while(zeros >= k) {
                        if(nums[left] == 0) zeros--;
                        left++;
                    }
                    zeros++;
                    // ans = Math.max(ans, right-left+1);
                    // right++;
                }
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}