package DynammicProgramming.Grid;

import java.util.List;

public class TrianglePath {
    class Memoization {
        Integer[][] memo;

        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            if(n==1) return triangle.get(0).get(0);

            memo = new Integer[n][n];
            return solve(0, 0, triangle);
        }

        public int solve(int r, int c, List<List<Integer>> triangle) {
            if(r==triangle.size()-1) return triangle.get(r).get(c);

            if(memo[r][c]!=null) return memo[r][c];

            int down = solve(r+1, c, triangle);
            int diagonal = solve(r+1, c+1, triangle);

            return memo[r][c] = triangle.get(r).get(c) + Math.min(down, diagonal);
        }
    }

    class Tabulation {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();

            int[][] dp = new int[n][n];

            //copying last row
            for(int c=0;c<n;c++) {
                dp[n-1][c] = triangle.get(n-1).get(c);
            }

            for(int r=n-2;r>=0;r--) {
                for(int c=0;c<=r;c++) {
                    dp[r][c] = triangle.get(r).get(c) + Math.min(dp[r+1][c], dp[r+1][c+1]);
                }
            }

            return dp[0][0];
        }
    }
}
