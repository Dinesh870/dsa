class Solution {
    boolean isPalindrome(String s, int i , int j) {
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    // String fun(int i, int j, String s, String[] ans) {

    //     if(i>j) return "";
        
    //     if(isPalindrome(s, i, j)) {
    //         // if((j-i) >= ans[0].length()) 
    //         //     ans[0] = s.substring(i,j+1);
    //         return s.substring(i,j+1);
    //     }

    //     String left = fun(i+1,j,s,ans);
    //     String right = fun(i,j-1,s, ans);

    //     if(left.length() > right.length()) return left;

    //     return right;
    // }
    String fun(int i, int j, String s, String[][] dp) {

        if(i>j) return "";
        if(dp[i][j] != null) return dp[i][j];
        
        if(isPalindrome(s, i, j)) {
            // if((j-i) >= ans[0].length()) 
            //     ans[0] = s.substring(i,j+1);
            return dp[i][j] = s.substring(i,j+1);
        }

        String left = fun(i+1,j,s, dp);
        String right = fun(i,j-1,s, dp);

        if(left.length() > right.length()) return dp[i][j] = left;

        return dp[i][j] = right;
    }
    public String longestPalindrome(String s) {
        // String temp = "";
        int n = s.length();
        // for(int i = 0; i < n; i++) {
        //     for(int j = i; j < n; j++) {
        //         if(isPalindrome(s, i, j) && ((j-i) >= temp.length())) {
        //             temp = s.substring(i,j+1);
        //         }
        //     }
        // }
        // return temp;
        // String[] ans = new String[1];
        // ans[0] = "";
        // fun(0, n-1, s, ans);
        // return ans[0];

        String[][] dp = new String[n][n];
        for(int i = 0; i < n ;i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = null;
            }
        }
        return fun(0, n-1, s, dp);
    }
}