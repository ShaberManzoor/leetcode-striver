package Strings.Medium;

public class LargestNestedParanthesis {
    public static void main(String[] args) {
        String s = "(((4)))";
        System.out.println(maxDepth(s));
    }
    public static int maxDepth(String s){
        int open = 0;
        int ans = 0;
        for(char ch: s.toCharArray()){
            if(ch=='(') open++;
            else if(ch==')') open--;

            ans = Math.max(open, ans);
        }

        return ans;
    }
}
