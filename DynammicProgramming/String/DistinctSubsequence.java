package DynammicProgramming.String;

public class DistinctSubsequence {
    class Memoization {
        Integer[][] memo;

        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            memo = new Integer[m+1][n+1];

            return solve(m, s, n, t);    
        }

        public int solve(int i, String s, int j, String t) {
            if(j==0) return 1;
            if(i==0) return 0;

            if(memo[i][j]!=null) return memo[i][j];

            if(s.charAt(i-1)==t.charAt(j-1)) {
                return memo[i][j] = solve(i-1, s, j-1, t) + solve(i-1, s, j, t);
            }

            return memo[i][j] = solve(i-1, s, j, t);
        }
    }

    class Tabulation {
        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] dp = new int[m+1][n+1];

            // Empty t can be formed in exactly 1 way
            for (int i = 0; i <= m; i++) {
                dp[i][0] = 1;
            }

            for(int i=1;i<=m;i++) {
                for(int j=1;j<=n;j++) {
                    dp[i][j] = dp[i-1][j];
                    if(s.charAt(i-1)==t.charAt(j-1)) {
                        dp[i][j] += dp[i-1][j-1];
                    }
                }
            }

            return dp[m][n];
        }
    }
}
