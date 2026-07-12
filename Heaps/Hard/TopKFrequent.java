package Heaps.Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node {
    int num, freq;
    Node(int num, int freq){
        this.num = num;
        this.freq = freq;
    }   
}
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>(); //{val, freq}

        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0));
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.freq-b.freq);

        for(int key: freqMap.keySet()){
            minHeap.offer(new Node(key, freqMap.get(key)));

            if(minHeap.size()>k) minHeap.poll();
        }

        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll().num;
        }

        return res;
    }
}
