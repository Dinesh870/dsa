class Solution {
    int fun(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + fun(i-1, j-1, s1, s2, dp);

        return dp[i][j] = Math.max(fun(i-1, j, s1, s2, dp), fun(i, j-1, s1, s2, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        // int[][] dp = new int[n1+1][n2+1];
        // for(int[] arr : dp) Arrays.fill(arr, -1);

        // return fun(n1-1, n2-1, text1, text2, dp);

        // tabulation
        // Base case
        // for(int i = 0; i <= n1; i++) {
        //     dp[i][0] = 0;
        // }
        // for(int i = 0; i <= n2; i++) {
        //     dp[0][i] = 0;
        // }
        // // if(text1.charAt(0) == text2.charAt(0)) dp[0][0] = 1;

        // for(int i = 1; i <= n1; i++) {
        //     for(int j = 1; j <= n2; j++) {
        //         if(text1.charAt(i-1) == text2.charAt(j-1))
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         else 
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //     }
        // }
        // return dp[n1][n2];

        // space optimization
        int m = Math.max(n1,n2);
        int[] prev = new int[m+1];
        for(int i = 0; i <= m; i++) {
            prev[0] = 0;
        }

        for(int i = 1; i <= n1; i++) {
            int[] curr = new int[m+1];
            for(int j = 1; j <= n2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
                else 
                    curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr;
        }
        return prev[n2];
    }
}