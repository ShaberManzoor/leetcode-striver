package Heaps.Hard;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap, minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        if(maxHeap.size()>minHeap.size()+1) minHeap.offer(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()) return (minHeap.peek() + maxHeap.peek()) / 2.0;

        return maxHeap.peek();
    }
}
