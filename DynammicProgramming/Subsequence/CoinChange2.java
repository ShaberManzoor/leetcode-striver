package DynammicProgramming.Subsequence;

public class CoinChange2 {
    class Memoizaiton {
        Integer[][] memo;

        public int change(int amount, int[] coins) {
            if(amount==0) return 1;

            int n = coins.length;
            memo = new Integer[n][amount+1];

            return solve(n-1, amount, coins);
        }

        public int solve(int i, int amount, int[] coins) {
            if(amount==0) return 1;
            if(i==0) return amount%coins[0]==0 ? 1 : 0;

            if(amount<0) return 0;

            if(memo[i][amount]!=null) return memo[i][amount];

            int take = solve(i, amount-coins[i], coins);
            int skip = solve(i-1, amount, coins);

            return memo[i][amount] = take + skip;
        }
    }

    class Tabulation {
        public int change(int amount, int[] coins) {
            if(amount==0) return 1;

            int n = coins.length;
            int dp[][] = new int[n][amount+1];

            //base case
            for(int tar=1;tar<=amount;tar++) {
                if(tar%coins[0]==0) dp[0][tar] = 1;
            }

            for(int i=1;i<n;i++) {
                for(int tar=1;tar<=amount;tar++) {
                    //skip
                    int skip = dp[i-1][tar];
                    
                    //take
                    int take = coins[i]<=tar ? dp[i][tar-coins[i]] : 0;

                    dp[i][tar] = skip + take;
                }
            }

            return dp[n-1][amount];
        }

        public int changeOptimised(int amount, int[] coins) {
            int dp[] = new int[amount+1];
            dp[0] = 1;

            for(int coin: coins) {
                for(int tar=coin;tar<=amount;tar++) {
                    dp[tar] += dp[tar-coin];
                }
            }

            return dp[amount];
        }
    }
}
