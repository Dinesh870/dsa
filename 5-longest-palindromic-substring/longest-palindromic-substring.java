class Solution {
    boolean isPalindrome(String s, int i , int j) {
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String temp = "";
        int n = s.length();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j) && ((j-i) >= temp.length())) {
                    temp = s.substring(i,j+1);
                }
            }
        }
        return temp;
    }
}