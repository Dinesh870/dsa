class Solution {
    int fun(int i, int j, String s, int[][] dp) {
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + fun(i+1, j-1, s, dp);
        }
        return dp[i][j] = Math.max(fun(i+1, j, s, dp), fun(i, j-1, s, dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return fun(0, n-1, s, dp);
    }
}