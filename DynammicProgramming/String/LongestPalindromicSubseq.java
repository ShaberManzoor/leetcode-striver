package DynammicProgramming.String;

public class LongestPalindromicSubseq {
    Integer[][] memo;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n==1) return 1;

        memo = new Integer[n+1][n+1];
        String s2 = new StringBuilder(s).reverse().toString();

        //To find the Longest common subseq of s we will find LCS between s and it reverse

        return solve(n, s, n, s2);
    }

    public int solve(int i, String s1, int j, String s2) {
        if(i==0 || j==0) return 0;

        if(memo[i][j]!=null) return memo[i][j];

        if(s1.charAt(i-1)==s2.charAt(j-1)) {
            return memo[i][j] = 1 + solve(i-1, s1, j-1, s2);
        }

        return memo[i][j] = Math.max(solve(i, s1, j-1, s2), solve(i-1, s1, j, s2));
    }
}
