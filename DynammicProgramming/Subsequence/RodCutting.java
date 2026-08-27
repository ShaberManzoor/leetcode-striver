package DynammicProgramming.Subsequence;

public class RodCutting {
    class Memoization {
        public int cutRod(int[] price) {
            int n = price.length;
    
            //Using 2D array
            // Integer[][] memo1 = new Integer[n][n+1];
            // return solve(price, n, n, memo1);
    
            //Using 1D array
            Integer[] memo2 = new Integer[n];
            return solveOptimised(price, n, memo2);
        }
    
        public int solve(int[] price, int n, int i, Integer[][] memo) {
            // max profit by cutting the rod of length 0
            if(n==0) return 0;
    
            //only piece of length 1 left
            if(i==1) return n * price[0];
    
            if(memo[i][n]!=null) return memo[i][n];
    
            int cut = i<=n ? price[i-1] + solve(price, n-i, i, memo) : 0;
            int dontCut = solve(price, n, i-1, memo);
    
            return memo[i][n] = Math.max(cut, dontCut);
        }
    
        public int solveOptimised(int price[], int n, Integer[] memo) {
            // max profit by cutting the rod of length 0
            if(n==0) return 0;
    
            if(memo[n]!=null) return memo[n];
    
            int max = 0;
            for(int cut=1;cut<=n;cut++) {
                int take = price[cut-1] + solveOptimised(price, n-cut, memo); 
                max = Math.max(max, take);
            }
    
            return memo[n] = max;
        }
    }

    class Tabulation {
        public int solve(int[] price) {
            int n = price.length;
            if(n==1) return price[0];

            //maximum profit we can obtain by using the index 0..i for length n 
            Integer[][] dp = new Integer[n][n+1];

            for(int len=1;len<=n;len++) {
                dp[0][len] = price[0] * len;
            }

            for(int i=1;i<n;i++) {
                for(int len=1;len<=n;len++) {
                    int cut = i<=len ? price[i] + dp[i-1][len-i];
                    dp[i][len] = 
                }
            }
        }
    }
}
