package Strings.Easy;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeba";
        System.out.println(rotateString(s, goal));
    }
    public static boolean rotateString(String s, String goal){
        if(s.length()!=goal.length()) return false;

        int n = s.length();
        s += s;
        for(int i=0;i<n;i++){
            if(s.substring(i, i+n).equals(goal)) return true;
        }

        return false;
    }
}
