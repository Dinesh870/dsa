class Solution {
    int fun(String s, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 0 + fun(s, i + 1, j-1, dp);
        }
        return dp[i][j] = Math.min(1 + fun(s, i+1, j, dp) , 1 + fun(s, i, j-1, dp));
    }
    public int minInsertions(String s) {
        int n = s.length();
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
    }
}