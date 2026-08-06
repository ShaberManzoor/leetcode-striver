package Graphs.ShortestPathsAlgos;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathUndirected {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        
        for(int edge[]: edges) {
            adj.putIfAbsent(edge[0], new HashSet<>());
            adj.putIfAbsent(edge[1], new HashSet<>());
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            if (!adj.containsKey(node)) continue;
            
            for(int neigh: adj.get(node)) {
                if(dist[neigh]>dist[node]+1) {
                    q.offer(neigh);
                    dist[neigh] = dist[node] + 1;
                }
            }
        }
        
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}
