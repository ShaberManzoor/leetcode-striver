package DynammicProgramming.Stocks;

public class BuyAndSellWithFee {
    class Memoization {
        Integer[][] memo;

        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            if(n==1) return 0;

            memo = new Integer[n][2];
            return solve(prices, 0, 1, fee);
        }

        public int solve(int[] prices, int day, int canBuy, int fee) {
            if(day==prices.length) return 0;

            if(memo[day][canBuy]!=null) return memo[day][canBuy];

            int profit;
            if(canBuy==1) {
                int buy = -prices[day] + solve(prices, day+1, 0, fee);
                int dontBuy = solve(prices, day+1, 1, fee);

                profit = Math.max(buy, dontBuy);
            } else {
                int sell = prices[day] - fee + solve(prices, day+1, 1, fee);
                int dontSell = solve(prices, day+1, 0, fee);

                profit = Math.max(sell, dontSell);
            }

            return memo[day][canBuy] = profit;
        }
    }

    class Tabulation {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            if(n==1) return 0;

            int dp[][] = new int[n][2];
            
            //Base Case
            dp[0][1] = -prices[0];
            for(int day=1;day<n;day++) {
                //buy or skip
                dp[day][1] = Math.max(dp[day-1][0] - prices[day], dp[day-1][1]);

                //sell or skip
                dp[day][0] = Math.max(dp[day-1][1] + prices[day] - fee, dp[day-1][0]);
            }

            return dp[n-1][0];
        }
    }
        
    class Greedy {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            
            int cash = 0; //max profit when we dont hold any stock
            int hold = -prices[0]; // max profit when we hold the stock

            for(int day=1;day<n;day++) {

                // sell today or skip
                cash = Math.max(hold + prices[day] - fee, cash);

                // buy today or hold
                hold = Math.max(cash - prices[day], hold);
            }

            return cash;
        }
    }
}
