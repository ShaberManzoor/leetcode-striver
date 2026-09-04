package DynammicProgramming.Stocks;

public class BuyAndSell4 {
    class Memoization {
        //memo[i][1][k] max profit from day 0 to i after k transaction if we can buy the stock on i-th day
        Integer memo[][][];

        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if(n==1) return 0;

            memo = new Integer[n][2][k+1];

            return solve(prices, 0, 1, k);
        }

        public int solve(int[] prices, int day, int canBuy, int k) {
            if(k==0 || day==prices.length) return 0;

            if(memo[day][canBuy][k]!=null) return memo[day][canBuy][k];

            int profit;

            //if we can buy the stock
            if(canBuy==1) {
                int buy = -prices[day] + solve(prices, day+1, 0, k);
                int skip = solve(prices, day+1, 1, k);

                profit = Math.max(buy, skip);
            } 
            // we can sell the stock
            else {
                int sell = prices[day] + solve(prices, day+1, 1, k-1);
                int skip = solve(prices, day+1, 0, k);

                profit = Math.max(sell, skip);
            }

            return memo[day][canBuy][k] = profit;
        }
    }

    class Tabulation {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if(n==1) return 0;

            int[][][] dp = new int[n+1][2][k+1];

            for (int day = n - 1; day >= 0; day--) { 
                for (int canBuy = 0; canBuy <= 1; canBuy++) { 
                    for (int cap = 1; cap <= k; cap++) { 
                        if (canBuy == 1) { 
                            // Buy or skip 
                            dp[day][1][cap] = Math.max( -prices[day] + dp[day + 1][0][cap], dp[day + 1][1][cap] ); 
                        } else { 
                            // Sell or skip 
                            dp[day][0][cap] = Math.max( prices[day] + dp[day + 1][1][cap - 1], dp[day + 1][0][cap] ); 
                        } 
                    } 
                } 
            } 
            
            return dp[0][1][k];
        }
    }
}
