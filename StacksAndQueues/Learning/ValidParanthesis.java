package StacksAndQueues.Learning;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "[{}[]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;

                char top = st.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
