package DynammicProgramming.Stocks;

public class BuyAndSellCooldown {
    class Memoization {
        Integer memo[][];

        public int maxProfit(int[] prices) {
            int n = prices.length;

            if (n <= 1) return 0;

            memo = new Integer[n][2];

            return solve(prices, 0, 1);
        }

        public int solve(int[] prices, int day, int canBuy) {
            if (day>=prices.length) return 0;

            if (memo[day][canBuy] != null) {
                return memo[day][canBuy];
            }

            if (canBuy == 1) {
                // Buy today, so now we are holding a stock
                int buy = -prices[day] + solve(prices, day + 1, 0);

                // Skip buying today
                int dontBuy = solve(prices, day + 1, 1);

                memo[day][canBuy] = Math.max(buy, dontBuy);

            } else {
                // Sell today, then day+1 is a cooldown day
                int sell = prices[day] + solve(prices, day + 2, 1);

                // Skip selling today
                int dontSell = solve(prices, day + 1, 0);

                memo[day][canBuy] = Math.max(sell, dontSell);
            }

            return memo[day][canBuy];
        }
    }

    class Tabulation {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            if (n <= 1) return 0;

            int[][] dp = new int[n + 1][2];

            // Base cases
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int day = 1; day <= n; day++) {

                // Don't hold a stock:
                // either we already didn't hold it,
                // or we sell today.
                dp[day][0] = Math.max(
                    dp[day - 1][0],
                    prices[day - 1] + dp[day - 1][1]
                );

                // Hold a stock:
                // either we were already holding it,
                // or we buy today after cooldown.
                if (day == 1) {
                    dp[day][1] = Math.max(
                        dp[day - 1][1],
                        -prices[day - 1]
                    );
                } else {
                    dp[day][1] = Math.max(
                        dp[day - 1][1],
                        -prices[day - 1] + dp[day - 2][0]
                    );
                }
            }

            return dp[n][0];
        }
    }
}
