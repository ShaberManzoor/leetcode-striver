package Strings.Easy;

public class OuterParanthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0; //count the open paranthesis

        for(char ch: s.toCharArray()){
            if(ch=='('){
                if(open>0) sb.append(ch);
                open++;
            }else{
                open--;
                if(open>0) sb.append(ch);
            }
        }

        return sb.toString();
    }
}
