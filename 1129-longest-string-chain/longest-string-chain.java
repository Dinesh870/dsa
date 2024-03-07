class Solution {
    boolean check(String s1, String s2) {
        int i = 0, j = 0;
        int n1 = s1.length(), n2 = s2.length();
        if(n1+1 != n2) return false;

        while(j < n2) {
            if(i < n1 && s1.charAt(i)==s2.charAt(j)) i++;
            j++;
        }
        return i == n1 && j == n2;
    }
    int fun(int i, int preIdx, String[] words, int[][] dp) {

        if(i >= words.length) return 0;
        if(dp[i][preIdx+1] != -1) return dp[i][preIdx+1];

        int nottake = 0 + fun(i+1, preIdx, words, dp);
        int take = 0;
        if(preIdx == -1 || check(words[preIdx], words[i])) {
            preIdx = i;
            take = 1 + fun(i+1, preIdx, words, dp);
        }
        return dp[i][preIdx+1] = Math.max(take, nottake);
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[][] dp = new int[n][n+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);       
        // for(String s : words)System.out.print(s+" ");
        return fun(0, -1, words, dp);
    }
}