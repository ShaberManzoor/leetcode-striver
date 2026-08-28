package DynammicProgramming.String;

public class PrintLCS {
    static Integer[][] memo;

    public static String findLCS(int n, int m, String s1, String s2){
        memo = new Integer[n+1][m+1];

        solve(n, s1, m, s2);

        //building lcs
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;

        while(i>0 && j>0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                lcs.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(memo[i][j-1]>memo[i-1][j]) j--;
            else i--;
        }

        return lcs.reverse().toString();
    }

    public static int solve(int i, String s1, int j, String s2) {
        // Base case when one string becomes empty
        if(i==0 || j==0) return memo[i][j] = 0;

        if(memo[i][j]!=null) return memo[i][j];

        if(s1.charAt(i-1)==s2.charAt(j-1)) {
            return memo[i][j] = 1 + solve(i-1, s1, j-1, s2);
        } 

        return memo[i][j] = Math.max(solve(i-1, s1, j, s2), solve(i, s1, j-1, s2));
    }

    public static void main(String[] args) {
        String s1 = "abcab", s2 = "cbab";

        System.out.println("Longest Common Subsequence: " + findLCS(5, 4, s1, s2));
    }
}
