package Heaps.Hard;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for(int num: nums) add(num);
    }
    
    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size()>k) minHeap.poll();

        return minHeap.peek();
    }
}
