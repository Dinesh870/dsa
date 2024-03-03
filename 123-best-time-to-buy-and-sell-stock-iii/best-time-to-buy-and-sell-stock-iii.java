class Solution {
    int fun(int i, int buy, int cap, int[] prices, int[][][] dp) {

        if(cap == 0) return 0;
        if(i==prices.length) return 0;
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        int profit = 0;

        if(buy==1) {
            int canbuy = - prices[i] + fun(i+1, 0, cap, prices, dp);
            int notbuy = 0 + fun(i+1, 1, cap, prices, dp);
            profit = Math.max(canbuy, notbuy);
        } else {
            int cansell = prices[i] + fun(i+1, 1, cap-1, prices, dp);
            int notsell = 0 + fun(i+1, 0, cap, prices, dp);
            profit = Math.max(cansell, notsell);
        }
        return dp[i][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // memoization
        int[][][] dp = new int[n+1][2][3];
        // for(int[][] arr : dp) {
        //     for(int[] arr2 : arr) {
        //         Arrays.fill(arr2, -1);
        //     }
        // }
        // return fun(0, 1, 2, prices, dp);

        // tabulation
        // Base case 1 -- > if cap == 0 then i and buy can be any thing
        // for(int i = 0; i <= n; i++) {
        //     for(int buy = 0; buy <= 1; buy++) {
        //         dp[i][buy][0] = 0;
        //     }
        // }
        // Base case 2 -- > i == n then cap and buy can be any thing
        // for(int buy = 0; buy <= 1; buy++) {
        //     for(int cap = 0; cap <= 2; cap++) {
        //         dp[n][buy][cap] = 0;
        //     }
        // }

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    int profit = 0;

                    if(buy==1) {
                        int canbuy = - prices[i] + dp[i+1][0][cap];
                        int notbuy = 0 + dp[i+1][1][cap];
                        profit = Math.max(canbuy, notbuy);
                    } else {
                        int cansell = prices[i] + dp[i+1][1][cap-1];
                        int notsell = 0 + dp[i+1][0][cap];
                        profit = Math.max(cansell, notsell);
                    }
                    dp[i][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];

        // space optimization
        // int[][] prev = new int[2][4];

        // for(int i = n-1; i >= 0; i--) {
        //     for(int buy = 0; buy <= 1; buy++) {
        //         for(int cap = 1; cap <= 3; cap++) {
        //             int profit = 0;

        //             if(buy==1) {
        //                 int canbuy = - prices[i] + prev[0][cap];
        //                 int notbuy = 0 + prev[1][cap];
        //                 profit = Math.max(canbuy, notbuy);
        //             } else {
        //                 int cansell = prices[i] + prev[1][cap-1];
        //                 int notsell = 0 + prev[0][cap];
        //                 profit = Math.max(cansell, notsell);
        //             }
        //             prev[buy][cap] = profit;
        //         }
        //     }
        // }
        // return prev[1][2];
    }
}