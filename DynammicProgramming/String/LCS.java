package DynammicProgramming.String;

public class LCS {
    class Memoization {
        // LCS till index i of string 1 and index j of string 2
        Integer memo[][];

        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();

            memo = new Integer[m][n];

            return solve(text1, m-1, text2, n-1);
        }

        public int solve(String s1, int i, String s2, int j) {
            // base case: an empty string LCS will be 0
            if(i<0 || j<0) return 0;

            if(memo[i][j]!=null) return memo[i][j];

            if(s1.charAt(i)==s2.charAt(j)) {
                return memo[i][j] = 1 + solve(s1, i-1, s2, j-1);
            } 

            return memo[i][j] = Math.max(solve(s1, i-1, s2, j), solve(s1, i, s2, j-1));
        }
    }

    class Tabulation {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();

            int[][] dp = new int[m+1][n+1]; //lcs till length m of s1 & length n of s2

            for(int i=1;i<=m;i++) {
                for(int j=1;j<=n;j++) {
                    if(text1.charAt(i-1)==text2.charAt(j-1)) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            return dp[m][n];
        }

        public int longestCommonSubsequenceSpaceOpt(String text1, String text2) {
            int m = text1.length(), n = text2.length();

            int[] dp = new int[n+1]; //lcs till length m of s1 & length n of s2

            for(int i=1;i<=m;i++) {
                int temp[] = new int[n+1];
                for(int j=1;j<=n;j++) {
                    if(text1.charAt(i-1)==text2.charAt(j-1)) {
                        temp[j] = 1 + dp[j-1];
                    } else {
                        temp[j] = Math.max(dp[j], temp[j-1]);
                    }
                }

                dp = temp;
            }

            return dp[n];
        }
    }
}
