package DynammicProgramming.String;

public class MakeStringPal {
    public int minInsertions(String s) {
        // The approach is we will find the longest palindromic subsequence and subtract it from the length of string

        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        String rev = new StringBuilder(s).reverse().toString();

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1)==rev.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int palSubLength = dp[n][n];

        return n - palSubLength;
    }
}
