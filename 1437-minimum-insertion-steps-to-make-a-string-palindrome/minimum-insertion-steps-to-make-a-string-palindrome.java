class Solution {
    int fun(String s, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 0 + fun(s, i + 1, j-1, dp);
        }
        return dp[i][j] = 1 + Math.min(fun(s, i+1, j, dp) , fun(s, i, j-1, dp));
    }
    public int minInsertions(String s) {
        int n = s.length();
        // memoization
        int[][] dp = new int[n][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        int ans = fun(s, 0, n-1, dp);
        // for(int[] arr : dp) {
        //     for(int i : arr) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }
        return ans;

        // tabulation
        // Base case

        // for(int i = 1; i < n; i++) {
        //     for(int j = 1; j < n; j++) {
        //         if(s.charAt(i) == s.charAt(j))
        //             dp[i][j] = 0 + dp[i+1][j-1];
        //         else
        //             dp[i][j] = Math.min(1 + fun(s, i+1, j, dp) , 1 + fun(s, i, j-1, dp));
        //     }
        // }
    }
}