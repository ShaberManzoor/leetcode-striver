package DynammicProgramming.Subsequence;

public class MinCoins {
    static class Memoization {
        //minimum coins need to make the amount using coins till index i 
        Integer memo[][];
        int INF = 1_000_000_000;

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            memo = new Integer[n][amount+1];

            int minCoins = solve(n-1, coins, amount);
            return minCoins==INF ? -1 : minCoins;
        }

        public int solve(int ind, int[] coins, int amount) {
            if(amount==0) return 0;

            if(ind<0) return INF;

            if(memo[ind][amount]!=null) return memo[ind][amount];

            //skip
            int skip = solve(ind-1, coins, amount);

            //take
            int take = coins[ind]<=amount ? 1 + solve(ind, coins, amount-coins[ind]) : INF;

            return memo[ind][amount] = Math.min(take, skip);
        }
    }

    static class Tabulation {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int dp[][] = new int[n][amount+1];

            //fill the first row base case 
            for(int tar=1;tar<=amount;tar++) {
                if(tar%coins[0]==0) dp[0][tar] = tar/coins[0];
                else dp[0][tar] = (int) 1e9;
            }

            for(int i=1;i<n;i++) {
                for(int tar=1;tar<=amount;tar++) {
                    int skip = dp[i-1][tar];
                    int take = coins[i]<=tar ? 1 + dp[i][tar-coins[i]] : (int) 1e9;

                    dp[i][tar] = Math.min(skip, take);
                }
            }

            return dp[n-1][amount]==1e9 ? -1 : dp[n-1][amount];
        }
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;

        Memoization memo = new Memoization();
        System.out.println("Memoization- " + memo.coinChange(coins, amount));

        Tabulation tab = new Tabulation();
        System.out.println("Tabulation- " + tab.coinChange(coins, amount));
    }
}
