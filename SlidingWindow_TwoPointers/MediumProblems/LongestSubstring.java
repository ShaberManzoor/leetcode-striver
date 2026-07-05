package SlidingWindow_TwoPointers.MediumProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "pwwekw";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (!set.contains(ch)) {
                set.add(ch);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}
