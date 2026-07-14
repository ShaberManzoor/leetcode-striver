package Heaps.Hard;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectStick {
    public static long minimumCostToConnectSticks(ArrayList<Integer> arr) {
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: arr){
            minHeap.offer(num);
        }

        long totalCost = 0;

        while(minHeap.size()>1){
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;
            
            minHeap.offer(cost);
        }

        return totalCost;
	}
}
