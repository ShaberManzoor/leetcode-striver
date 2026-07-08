package SlidingWindow_TwoPointers.MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int fruits[] = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int left = 0, maxLen = 0;

        for(int right=0;right<n;right++){
            int fruit = fruits[right];
            hm.put(fruit, hm.getOrDefault(fruit,0) + 1);
            
            while(hm.size()>2){
                hm.put(fruits[left], hm.get(fruits[left])-1);

                if(hm.get(fruits[left])==0) hm.remove(fruits[left]);

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
