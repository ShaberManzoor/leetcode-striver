package Greedy.Easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        //sorting greedy and size array
        Arrays.sort(g);
        Arrays.sort(s);

        int content = 0;
        int i = 0, j = 0;

        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                i++;
                content++;
            }
            j++;
        }

        return content;
    }
}
