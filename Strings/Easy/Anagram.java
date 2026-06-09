package Strings.Easy;

import java.util.HashSet;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()) return false;

        HashSet<Character> hs = new HashSet<>();
        for(char ch: s.toCharArray()){
            hs.add(ch);
        }

        for(char ch: t.toCharArray()){
            if(!hs.contains(ch)) return false;
        }

        return true;
    }
}
