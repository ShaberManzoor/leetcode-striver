package Strings.Medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    static int romanToInt(String s){
        int n = s.length();
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        int i=0, romanVal = 0;
        while(i<n){
            int currCharVal = romanToInt.get(s.charAt(i));
            int nextCharVal = i<n-1 ? romanToInt.get(s.charAt(i+1)) : Integer.MIN_VALUE;
            if(currCharVal < nextCharVal) {
                romanVal += (nextCharVal - currCharVal);
                i++;
            }else{
                romanVal += currCharVal;
            }
            i++;
        }

        return romanVal;
    }
}
