package DynammicProgramming.Grid;

import java.util.Arrays;

public class MinPathSum {
    static class Memoization {
        int memo[][];

        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            // if there is single row then the minimum sum will be the of sum of first row elements
            if(m==0) {
                int minSum = 0;
                for(int col=0;col<n;col++) minSum += grid[0][col];

                return minSum;
            }

            // if there is single col then the minimum sum will be the of sum of first col elements
            if(n==0) {
                int minSum = 0;
                for(int row=0;row<m;row++) minSum += grid[row][0];

                return minSum;
            }

            memo = new int[m][n];
            for(int row[]: memo) {
                Arrays.fill(row, -1);
            }

            return solve(m-1, n-1, grid);
        }

        public int solve(int r, int c, int[][] grid) {
            if(r==0 && c==0) return memo[0][0] = grid[0][0];

            if(memo[r][c]!=-1) return memo[r][c];

            // minimum sum of path of point from where we move bottom to reach r, c 
            int bottom = r>0 ? solve(r-1, c, grid) : Integer.MAX_VALUE;

            // minimum sum of path of point from where we move right to reach r, c 
            int right = c>0 ? solve(r, c-1, grid) : Integer.MAX_VALUE;

            return memo[r][c] = grid[r][c] + Math.min(bottom, right);
        }
    }

    static class Tabulation {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int dp[][] = new int[m][n];

            for(int r=0;r<m;r++) {
                for(int c=0;c<n;c++) {
                    if(r==0 && c==0) {
                        dp[0][0] = grid[0][0];
                        continue;
                    }

                    int above = r>0 ? dp[r-1][c] : Integer.MAX_VALUE;
                    int left = c>0 ? dp[r][c-1] : Integer.MAX_VALUE;

                    dp[r][c] = grid[r][c] + Math.min(above, left);
                }
            }

            return dp[m-1][n-1];
        }
    }

    public static void main(String args) {
        int grid[][] = {{1, 4, 5}, {1, 1, 2}};

        Memoization memo = new Memoization();
        System.out.println(memo.minPathSum(grid));

        Tabulation tabu = new Tabulation();
        System.out.println(tabu.minPathSum(grid));
    }
}
