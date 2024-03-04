class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        if(n == 0 || tokens[0] > power) return 0;
        int i = 0, j = n-1;
        int score = 0;
        int ans = 0;

        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i];
                i++;
                score += 1;
                ans = Math.max(ans, score);
            } else if (score > 0) {
                power += tokens[j];
                j--;
                score--;
            } else break;
            
        }
        return ans;
    }
}