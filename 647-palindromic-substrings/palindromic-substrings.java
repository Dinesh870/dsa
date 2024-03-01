class Solution {
    boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    void fun(int i, String s, int[] ans) {

        if(i < 0) return;

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s,i,j)) 
                ans[0]++;
        }
        fun(i-1, s,ans);
    } 
    public int countSubstrings(String s) {
        // Brute force
        // int cnt = 0;
        int n = s.length();
        // for(int i = 0; i < n; i++) {
        //     for(int j = i; j < n; j++) {
        //         if(isPalindrome(s, i, j)) cnt++;
        //     }
        // }
        // return cnt;

        // dp
        // memoization
        int[] ans = new int[1];
        fun(n-1, s, ans);

        return ans[0];
    }
}