package Strings.Medium;

public class LongestPalindrome {
    public static String longestPalindrome(String s){
        int n = s.length();
        if(n==1) return s;

        StringBuilder sb = new StringBuilder(s.substring(0, 1));
        for(int i=0;i<n;i++){
            String oddPalindrome = palindrome(s, i, i); //odd palindromic string possible from this index
            String evenPalindrome = palindrome(s, i, i+1); //even palindromic string possible from this index

            if(oddPalindrome.length() > sb.length()){
                sb = new StringBuilder(oddPalindrome);
            }
            if(evenPalindrome.length() > sb.length()){
                sb = new StringBuilder(evenPalindrome);
            }
        }

        return sb.toString();
    }

    static String palindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }

        return s.substring(l+1, r);
    }
}
