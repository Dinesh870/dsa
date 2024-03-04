class Solution {
    int fun(int idx, int prevIdx, int[] nums, int[][] dp) {

        if(idx == nums.length) return 0;
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];

        int nottake = 0 + fun(idx + 1, prevIdx, nums, dp);
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + fun(idx+1, idx, nums, dp);
        }
        return dp[idx][prevIdx+1] = Math.max(take, nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return fun(0,-1,nums, dp);
    }
}