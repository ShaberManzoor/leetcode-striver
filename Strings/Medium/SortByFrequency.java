package Strings.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortByFrequency {
    public static void main(String[] args) {
        String s = "aabbbAAccc";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s){
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch: s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length()+1];
        
        for(char c: freq.keySet()){
            int f = freq.get(c);
            if(bucket[f]==null) {
                bucket[f] = new ArrayList<>();
            }

            bucket[f].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=bucket.length-1;i>=1;i--){
            if(bucket[i]!=null){
                for(char c: bucket[i]){
                    for(int j=0;j<i;j++){
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
