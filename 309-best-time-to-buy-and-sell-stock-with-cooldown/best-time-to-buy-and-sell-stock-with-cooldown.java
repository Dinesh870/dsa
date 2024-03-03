class Solution {
    int fun(int i, int buy, int[] prices, int[][] dp) {

        if(i>=prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if(buy == 1) {
            int canbuy = - prices[i] + fun(i+1, 0, prices, dp);
            int notbuy = 0 + fun(i+1, 1, prices, dp);
            profit = Math.max(canbuy, notbuy);
        } else {
            int cansell = prices[i] + fun(i+2, 1, prices, dp);
            int notsell = 0 + fun(i+1, 0, prices, dp);
            profit = Math.max(cansell, notsell);
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return fun(0,1,prices, dp);
    }
}