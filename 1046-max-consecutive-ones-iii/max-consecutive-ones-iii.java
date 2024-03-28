class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int n = nums.length;
        int left = 0, right = 0;
        int ans = 0;

        while(right < n) {
            if(nums[right] == 1) {
                ans = Math.max(ans, right - left+1);
                right++;
            } else {
                if(zeros < k) {
                    ans = Math.max(ans, right-left+1);
                    right++;
                    zeros++;
                } else {
                    while(zeros >= k) {
                        if(nums[left] == 0) zeros--;
                        left++;
                    }
                    zeros++;
                    ans = Math.max(ans, right-left+1);
                    right++;
                }
            }
        }
        return ans;
    }
}