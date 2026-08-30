package DynammicProgramming.String;

public class WildcardMatch {
    class Memoization {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();

            boolean[][] dp = new boolean[m+1][n+1];

            // both the empty string are equal
            dp[0][0] = true;

            // Empty string can be matched only by '*' characters 
            for (int j = 1; j <= n; j++) { 
                if (p.charAt(j - 1) == '*') { 
                    dp[0][j] = dp[0][j - 1]; 
                } 
            }

            for(int i=1;i<=m;i++) {
                for(int j=1;j<=n;j++) {
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if (p.charAt(j-1)=='*') {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            return dp[m][n];
        }
    }

    class Tabulation {
        // is first i character of s matches the j char of p
        Boolean memo[][];

        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            memo = new Boolean[m+1][n+1];

            return isMatchUtil(m, s, n, p);
        }

        public boolean isMatchUtil(int i, String s, int j, String p) {
            if(i==0 && j==0) return true;
            if(i==0 && j>0) return isAllStars(p, j);
            if(i>0 && j==0) return false;

            if(memo[i][j]!=null) return memo[i][j];

            if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                return memo[i][j] = isMatchUtil(i-1, s, j-1, p);
            } else if (p.charAt(j-1)=='*') {
                return memo[i][j] = isMatchUtil(i-1, s, j, p) || isMatchUtil(i, s, j-1, p);
            }

            return memo[i][j] = false;
        }

        public boolean isAllStars(String p, int j) {
            for(int i=0;i<j;i++) {
                if(p.charAt(i)!='*') return false;
            }

            return true;
        }
    }
}
