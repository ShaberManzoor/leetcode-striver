package StacksAndQueues.ImpProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDigits {
    public static void main(String[] args) {
        String num = "11881";
        int k = 2;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if(n==k) return "0";
        
        Deque<Character> st = new ArrayDeque<>();
        for(char c: num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peekLast()>c){
                st.pollLast();
                k--;
            }
            st.offerLast(c);
        }

        //now removing the remaining from this increasing monotonic stack
        while(k-->0){
            st.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char c = st.pollFirst();
            if(c=='0' && sb.length()==0) continue;

            sb.append(c);
        }

        return sb.toString();
    }
}
