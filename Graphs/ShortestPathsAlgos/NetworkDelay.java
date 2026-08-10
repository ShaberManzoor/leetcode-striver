package Graphs.ShortestPathsAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int time[]: times) {
            int u = time[0], v = time[1], w = time[2];
            adj.get(u).add(new int[]{v, w});
        }

        int time[] = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k ,0});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int currNode = curr[0], currTime = curr[1];

            if(currTime!=time[currNode]) continue; //skip outdated values;

            for(int[] next: adj.get(currNode)) {
                int nextNode = next[0], nextTime = next[1];

                if(nextTime+currTime<time[nextNode]) {
                    time[nextNode] = nextTime + currTime;
                    pq.offer(new int[]{nextNode, time[nextNode]});
                }
            }
        }

        //checking if all visited and the maxTime
        int maxTime = 0;
        boolean allVisited = true;
        for(int i=1;i<=n;i++) {
            if(time[i]==Integer.MAX_VALUE) {
                allVisited = false;
                break;
            }
            maxTime = Math.max(time[i], maxTime);
        }

        return allVisited ? maxTime : -1;
    }
}
