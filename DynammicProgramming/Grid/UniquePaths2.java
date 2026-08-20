package DynammicProgramming.Grid;

import java.util.Arrays;

public class UniquePaths2 {
    static class Memoization {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;

            int memo[][] = new int[m][n];
            for(int row[]: memo) {
                Arrays.fill(row, -1);
            } 

            return solve(m-1, n-1, obstacleGrid, memo);
        }

        public int solve(int i, int j, int[][] grid, int[][] memo) {
            if(grid[i][j]==1) return memo[i][j] = 0;
            if(i==0 && j==0) return memo[i][j] = 1;

            if(memo[i][j]!=-1) return memo[i][j];

            int above = i>0 ? solve(i-1, j, grid, memo) : 0;
            int left = j>0 ? solve(i, j-1, grid, memo) : 0;

            return memo[i][j] = above + left;
        }
    }

    static class Tabulation {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;

            int dp[][] = new int[m][n];

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(i==0 && j==0) {
                        dp[i][j] = 1;
                        continue;
                    }

                    if(obstacleGrid[i][j]==1) {
                        dp[i][j] = 0;
                        continue;
                    }

                    int down = i>0 ? dp[i-1][j] : 0;
                    int right = j>0 ? dp[i][j-1] : 0;

                    dp[i][j] = down + right;
                }
            }
            
            return dp[m-1][n-1];
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {0, 0, 0, 0}};

        Memoization memo = new Memoization();
        System.out.println("TOP-DOWN: " + memo.uniquePathsWithObstacles(grid));

        Tabulation tab = new Tabulation();
        System.out.println("BOTTOM-UP: " + tab.uniquePathsWithObstacles(grid));
    }
}
