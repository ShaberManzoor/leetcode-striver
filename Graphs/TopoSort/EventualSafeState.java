package Graphs.TopoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class EventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // we will reverse the graph and will go from all the safest nodes to other nodes
        int n = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            revGraph.add(new ArrayList<>());
        }

        int indeg[] = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            indeg[i] = graph[i].length;
            if (indeg[i] == 0)
                q.offer(i);

            for (int neigh : graph[i]) {
                revGraph.get(neigh).add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int neigh : revGraph.get(node)) {
                indeg[neigh]--;
                if (indeg[neigh] == 0)
                    q.offer(neigh);
            }
        }

        Collections.sort(res);
        return res;
    }

    public List<Integer> eventualSafestNodesDfs(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n]; // 0-> unvisited, 1-> visiting, 2-> visited

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(dfs(i, graph, color)) res.add(i);
        }

        return res;
    }

    public boolean dfs(int node, int[][] graph, int color[]) {
        if(color[node]==1) return false; //there is a cycle
        if(color[node]==2) return true;

        color[node] = 1; // visiting

        for(int neigh: graph[node]) {
            if(!dfs(neigh, graph, color)) return false;
        }

        color[node] = 2; //mark as visited
        return true;
    }
}
