package DynammicProgramming.Subsequence;

public class UnboundKnapsack {
    public class Memoization {
        // maximum profit we can make using the element from ind 0...i
        static Integer[][] memo;

        public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
            memo = new Integer[n][w+1];

            return solve(n-1, w, profit, weight);
        }

        public static int solve(int i, int cap, int[] profit, int[] weight) {

            //Base case only one item left
            if(i==0) {
                return (cap/weight[0]) * profit[0];
            }

            if(memo[i][cap]!=null) return memo[i][cap];

            int take = weight[i]<=cap ? profit[i] + solve(i, cap-weight[i], profit, weight) : 0;
            int notTake = solve(i-1, cap, profit, weight);

            return memo[i][cap] = Math.max(take, notTake); 
        }
    }

    public class Tabulation {
        public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
            // max profit we can get by collecting n items with capacity of w
            int[][] dp = new int[n+1][w+1];

            for(int item=1;item<=n;item++) {
                for(int cap=1;cap<=w;cap++) {
                    int take = weight[item-1]<=cap ? profit[item-1] + dp[item][cap-weight[item-1]] : 0;
                    int notTake = dp[item-1][cap];

                    dp[item][cap] = Math.max(take, notTake); 
                }
            }

            return dp[n][w];
        }
    }
}
