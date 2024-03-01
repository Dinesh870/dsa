class Solution {
    int fun(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + fun(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(fun(i-1, j, s1, s2, dp), fun(i, j-1, s1, s2, dp));
    }
    // int fun(int i, int j, String s, int[][] dp) {
    //     if(i > j) return 0;
    //     if(i == j) return 1;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s.charAt(i) == s.charAt(j)) {
    //         return dp[i][j] = 2 + fun(i+1, j-1, s, dp);
    //     }
    //     return dp[i][j] = Math.max(fun(i+1, j, s, dp), fun(i, j-1, s, dp));
    // }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // for(int[] arr : dp) Arrays.fill(arr, -1);
        // int ans = fun(0, n-1, s, dp);
        // for(int[] arr: dp) {
        //     for(int i : arr) System.out.print(i+" ");
        //     System.out.println();
        // }
        // return ans;

        // method 2:
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(n-1, n-1, s, s2, dp);

    }
}