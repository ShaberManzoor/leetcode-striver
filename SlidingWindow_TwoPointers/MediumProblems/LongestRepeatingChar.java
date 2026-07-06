package SlidingWindow_TwoPointers.MediumProblems;

public class LongestRepeatingChar {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
    public static int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int n = s.length();
        int maxFreq = 0, maxLen = 0, i = 0;

        for(int j=0;j<n;j++){
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(j)-'A']);

            while(j-i+1 - maxFreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen;
    }
}
