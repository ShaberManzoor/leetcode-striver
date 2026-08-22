package DynammicProgramming.Grid;

public class ChocolatePickup {
    public class Memoization {
        static Integer[][][] memo;
        static int m, n;

        public static int maximumChocolates(int r, int c, int[][] grid) {
            // Write your code here.
            memo = new Integer[r][c][c];
            m = r;
            n = c;

            return solve(0, 0, c-1, grid);
        }

        public static int solve(int r, int c1, int c2, int[][] grid) {
            if(c1<0 || c1>=n || c2<0 || c2>=n) return -1_000_000_000;

            if (r == m - 1) {
                if (c1 == c2)
                    return grid[r][c1];
                else
                    return grid[r][c1] + grid[r][c2];
            }
            
            if(memo[r][c1][c2]!=null) return memo[r][c1][c2];

            int chocolates;
            if(c1==c2) {
                chocolates = grid[r][c1];
            } else {
                chocolates = grid[r][c1] + grid[r][c2];
            }

            int maxNext = -1_000_000_000;

            //alice direction
            for(int d1=-1;d1<=1;d1++) {
                //bob direction
                for(int d2=-1;d2<=1;d2++) {
                    maxNext = Math.max(maxNext, solve(r+1, c1+d1, c2+d2, grid));
                }
            }

            return memo[r][c1][c2] = chocolates + maxNext;
        }
    }
}
