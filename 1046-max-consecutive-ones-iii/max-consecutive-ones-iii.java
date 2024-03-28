class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int left = 0, right = 0;
        int ans = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                while(zeros >= k) {
                    if(nums[left] == 0) zeros--;
                    left++;
                }
                zeros++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}