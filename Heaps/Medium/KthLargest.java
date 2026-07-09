package Heaps.Medium;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int nums[] = {5, 1, 3, 2, 8};
        System.out.println(kthLargest(nums, 4));
    }
    
    public static int kthLargest(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            pq.offer(num);

            if(pq.size()>k) pq.poll();
        }

        return pq.peek();
    }
}
