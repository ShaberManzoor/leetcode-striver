package Strings.Easy;

public class ReverseStringWords {
    public static void main(String[] args) {
        String s = "the    sky is   blue    ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        int i = -1; //index at which the string word ends
        
        for(int j=s.length()-1;j>=0;j--){
            char ch = s.charAt(j);
            if(ch==' ' && i!=-1){
                if(!sb.isEmpty()) sb.append(" ");
                sb.append(s.substring(j+1, i+1));
                i = -1;
            }else if(ch!=' ' && i==-1){
                i = j;
            }
        }

        if(i!=-1) {
            if(!sb.isEmpty()) sb.append(" ");
            sb.append(s.substring(0, i+1));
        }

        return sb.toString();
    }
}
