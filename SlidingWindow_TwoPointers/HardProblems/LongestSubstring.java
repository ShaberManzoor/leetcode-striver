package SlidingWindow_TwoPointers.HardProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abbbcca";
        System.out.println(lengthOfLongestSubstring(s, 2));
    }
    public static int lengthOfLongestSubstring(String s, int k) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> hm = new HashMap<>();

        while(right<s.length()){
            char ch = s.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);

            while(hm.size()>k){
                hm.put(s.charAt(left), hm.get(s.charAt(left))-1);

                if(hm.get(s.charAt(left))==0) hm.remove(s.charAt(left));

                left++;
            }

            maxLen = Math.max(right-left+1, maxLen);
            right++;
        }

        return maxLen;
    }
}
