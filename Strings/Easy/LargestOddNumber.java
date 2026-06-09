package Strings.Easy;

public class LargestOddNumber {
    public static void main(String[] args) {
        String s = "89832";
        System.out.println(largestOddNumber(s));
    }
    public static String largestOddNumber(String s) {
        for(int i=s.length()-1;i>=0;i--){
            int num = Integer.valueOf(s.charAt(i));
            if((num&1)==1) return s.substring(0, i+1);
        }

        return "";
    }
}
