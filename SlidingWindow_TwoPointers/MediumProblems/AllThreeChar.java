package SlidingWindow_TwoPointers.MediumProblems;

public class AllThreeChar {
    public static void main(String[] args) {
        String s = "abcabac";
        System.out.println(numberOfSubstrings(s));
    }
    public static int numberOfSubstrings(String s) {
        int[] freq = new int[3];

        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            count += left;
        }

        return count;
    }
}
