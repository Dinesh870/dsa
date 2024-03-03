class Solution {
    int fun(int i, int buy, int[] prices, int[][] dp) {
        if(i == prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if(buy == 1) {
            int canbuy = - prices[i] + fun(i+1, 0, prices, dp);
            int notbuy = 0 + fun(i+1, 1, prices, dp);
            profit = Math.max(canbuy, notbuy);
        } else {
            int cansell = prices[i] + fun(i+1, 1, prices, dp);
            int notsell = 0 + fun(i+1, 0, prices, dp);
            profit = Math.max(cansell, notsell);
        }
        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // memoization
        int[][] dp = new int[n+1][2];
        // for(int[] arr : dp) Arrays.fill(arr, -1);
        // return fun(0, 1, prices, dp);

        // tabulation

        // for(int i = n-1; i >= 0; i--) {
        //     for(int buy = 0; buy <= 1; buy++) {
        //         int profit = 0;
        //         if(buy == 1) {
        //             int canbuy = - prices[i] + dp[i+1][0];
        //             int notbuy = 0 + dp[i+1][1];
        //             profit = Math.max(canbuy, notbuy);
        //         } else {
        //             int cansell = prices[i] + dp[i+1][1];
        //             int notsell = 0 + dp[i+1][0];
        //             profit = Math.max(cansell, notsell);
        //         }
        //         dp[i][buy] = profit;
        //     }
        // }
        
        // return dp[0][1];

        // space optimization
        int[] curr = new int[2];
        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    int canbuy = - prices[i] + curr[0];
                    int notbuy = 0 + curr[1];
                    profit = Math.max(canbuy, notbuy);
                } else {
                    int cansell = prices[i] + curr[1];
                    int notsell = 0 + curr[0];
                    profit = Math.max(cansell, notsell);
                }
                curr[buy] = profit;
            }
        }

        return curr[1];

    }
}