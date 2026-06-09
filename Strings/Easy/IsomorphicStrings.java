package Strings.Easy;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "f11", t = "b22";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (map.get(a) != b)
                    return false;
            } else {

                if (used.contains(b))
                    return false;

                map.put(a, b);
                used.add(b);
            }
        }

        return true;
    }
}
