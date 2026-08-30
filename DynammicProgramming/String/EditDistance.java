package DynammicProgramming.String;

public class EditDistance {
    class Tabulation {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();

            int[][] dp = new int[m+1][n+1];

            // word1 -> ""
            // Need to delete all characters
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }

            // "" -> word2
            // Need to insert all characters
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            for(int i=1;i<=m;i++) {
                for(int j=1;j<=n;j++) {
                    if(word1.charAt(i-1)==word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int in = 1 + dp[i][j-1];
                        int re = 1 + dp[i-1][j-1];
                        int de = 1 + dp[i-1][j];

                        dp[i][j] = Math.min(in, Math.min(re, de));
                    }
                }
            }

            return dp[m][n];
        }
    }

    class Memoization {
        // minimum operations to convert first i char of word1 to first j char of word2
        Integer[][] memo;

        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            memo = new Integer[m+1][n+1];

            return solve(m, word1, n, word2);
        }

        public int solve(int i, String s, int j, String t) {
            if(i==0) return j;
            if(j==0) return i;

            if(memo[i][j]!=null) return memo[i][j];

            if(s.charAt(i-1)==t.charAt(j-1)) {
                return memo[i][j] = solve(i-1, s, j-1, t);
            }

            int in = 1 + solve(i, s, j-1, t);
            int de = 1 + solve(i-1, s, j, t);
            int re = 1 + solve(i-1, s, j-1, t);

            return memo[i][j] = Math.min(in, Math.min(de, re));
        }
    }
}
