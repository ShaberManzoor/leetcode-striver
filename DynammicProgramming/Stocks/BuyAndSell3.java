package DynammicProgramming.Stocks;

public class BuyAndSell3 {
    class Memoization {
        //memo[i][0][k]-> maximum profit we can gain by buying the stock after i-th day with atmost k transaction 
        //memo[i][1][k]-> maximum profit we can gain by selling the stock after i-th day with atmost k transaction 
        Integer memo[][][];

        public int maxProfit(int[] prices) {
            int n = prices.length;
            if(n==1) return 0;

            memo = new Integer[n][2][3];
            return solve(prices, 0, 1, 2);
        }

        public int solve(int[] prices, int i, int canBuy, int cap) {
            if(i==prices.length || cap==0) return 0;
            
            if(memo[i][canBuy][cap]!=null) return memo[i][canBuy][cap];

            int profit;
            //we can buy the stock
            if(canBuy==1) {
                int buy = -prices[i] + solve(prices, i+1, 0, cap);
                int dontBuy = solve(prices, i+1, 1, cap);
                
                profit = Math.max(buy, dontBuy);
            } 
            // we can sell it
            else {
                int sell = prices[i] + solve(prices, i+1, 1, cap-1);
                int dontSell = solve(prices, i+1, 0, cap);

                profit = Math.max(sell, dontSell);
            }

            return memo[i][canBuy][cap] = profit;
        }
    }

    class MostOptimised {
        public int maxProfit(int[] prices) {
            int buy1 = Integer.MIN_VALUE;
            int sell1 = 0;

            int buy2 = Integer.MIN_VALUE;
            int sell2 = 0;

            for(int price: prices) {
                //buy or skip
                buy1 = Math.max(-price, buy1);
                sell1 = Math.max(buy1 + price, sell1);

                buy2 = Math.max(sell1 - price, buy2);
                sell2 = Math.max(buy2 + price, sell2);
            }

            return sell2;
        }
    }
}
