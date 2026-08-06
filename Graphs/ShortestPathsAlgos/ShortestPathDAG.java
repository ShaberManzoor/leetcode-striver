package Graphs.ShortestPathsAlgos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathDAG {
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
		Map<Integer, Set<int[]>> adj = new HashMap<>();
		
		for (int[] edge : edges) {
			adj.putIfAbsent(edge[0], new HashSet<>());
			adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
		}
		
		ArrayList<Integer> dis = new ArrayList<>();
		
		for (int i = 0; i < V; i++)
			dis.add(Integer.MAX_VALUE);
		
		dis.set(0, 0);
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		
		while (!q.isEmpty()) {
			int node = q.poll();
			
			if (!adj.containsKey(node))
				continue;
			
			for (int[] next : adj.get(node)) {
				int neigh = next[0];
				int wt = next[1];
				
				if (dis.get(node) != Integer.MAX_VALUE &&
				dis.get(neigh) > dis.get(node) + wt) {
					
					dis.set(neigh, dis.get(node) + wt);
					q.offer(neigh);
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			if (dis.get(i) == Integer.MAX_VALUE)
				dis.set(i, -1);
		}
		
		return dis;
	}
}
