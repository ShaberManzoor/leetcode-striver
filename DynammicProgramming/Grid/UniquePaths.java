package DynammicProgramming.Grid;

import java.util.Arrays;

public class UniquePaths {
    static class Memoization {
        public int uniquePaths(int m, int n) {
            if(m==1 || n==1) return 1;

            int memo[][] = new int[m][n]; //number of ways to reach the cell i, j
            for(int row[]: memo) {
                Arrays.fill(row, -1);
            }

            return solve(m-1, n-1, memo);
        }

        public int solve(int i, int j, int[][] memo) {
            if(i==0 || j==0) return memo[i][j] = 1;

            if(memo[i][j]!=-1) return memo[i][j];
            
            //no. of ways to get to the cell above the i, j
            int above = i-1 < 0 ? 0 : solve(i-1, j, memo);

            //no. of ways to get to the cell on left of the i, j
            int left = j-1 < 0 ? 0 : solve(i, j-1, memo);

            return memo[i][j] = above + left;
        }
    }

    static class Tabulation {
        public int uniquePathsSpaceOptimisation(int m, int n) {
            if(m==1 || n==1) return 1;

            int[] dp = new int[n];

            for(int i=0;i<m;i++) {
                int[] curr = new int[n]; //stores the ways to reach the row i 
                for(int j=0;j<n;j++) {
                    if(i==0 || j==0) {
                        curr[j] = 1;
                        continue;
                    } 

                    curr[j] = dp[j] + curr[j-1];
                }

                dp = curr;
            }

            return dp[n-1];
        }

        public int uniquePaths(int m, int n) {
            if(m==1 || n==1) return 1;

            int[][] dp = new int[m][n];

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                        continue;
                    } 

                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[m-1][n-1];
        }
    }
}
