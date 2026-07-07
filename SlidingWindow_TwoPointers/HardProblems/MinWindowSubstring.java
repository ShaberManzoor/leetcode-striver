package SlidingWindow_TwoPointers.HardProblems;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] need = new int[128];

        for (char c : t.toCharArray())
            need[c]++;

        int left = 0;
        int right = 0;

        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (need[ch] > 0)
                required--;

            need[ch]--;

            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);
                need[remove]++;
                if (need[remove] > 0)
                    required++;

                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}
