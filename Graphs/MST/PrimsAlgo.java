package Graphs.MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {
        PrimsAlgo obj = new PrimsAlgo();
        int V = 5;
        int[][] edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}};
        System.out.println(obj.spanningTree(V, edges));
    }
    public int spanningTree(int V, int[][] edges) {
        // adjency Matrix
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int edge[]: edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        boolean vis[] = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> Integer.compare(a[1], b[1]));
        
        int minWt = 0;
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], wt = curr[1];
            
            if(!vis[node]) {
                vis[node] = true;
                minWt += wt;
                
                for(int edge[]: adj.get(node)) {
                    int neighNode = edge[0], neighWt = edge[1];
                    if(!vis[neighNode]) pq.offer(new int[]{neighNode, neighWt});
                }
            }
        }
        
        return minWt;
    }
}
