class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length-1;
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