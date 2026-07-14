package Heaps.Medium;

import java.util.TreeMap;

public class HandOfStraight {
    public static void main(String[] args) {
        int hand[] = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        System.out.println(isNStraightHand(hand, groupSize));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>(); //to store the frequency of each card value
        for(int val: hand){
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        while(!freq.isEmpty()){
            int first = freq.firstKey();

            for(int val=first;val<first+groupSize;val++){
                if(!freq.containsKey(val)) return false;

                freq.put(val, freq.get(val)-1);

                if(freq.get(val)==0) freq.remove(val);
            }
        }
        
        return true;
    }
}
