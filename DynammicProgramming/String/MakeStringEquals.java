package DynammicProgramming.String;

public class MakeStringEquals {
    public int minDistance(String word1, String word2) {
        // The approach is we will find the longest common subsequence and subtract it from both the length of word1 and word2 to make them equal

        //Finding LCSubstring
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // subtracting extra char from both the strings
        return (m-dp[m][n]) + (n-dp[m][n]);
    }
}
