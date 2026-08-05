package Graphs.TopoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();

        int V = 6;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Graph:
        // 5 -> 2
        // 5 -> 0
        // 4 -> 0
        // 4 -> 1
        // 2 -> 3
        // 3 -> 1

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        List<Integer> topoSortBfs = ts.topoSort(V, graph);

        System.out.println("Topological Sort using BFS: " + topoSortBfs);

        List<Integer> topoSortDfs = ts.topoSortDfs(V, graph);

        System.out.println("Topological Sort using DFS: " + topoSortDfs);
    }
    
    public List<Integer> topoSort(int v, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        
        int indeg[] = new int[v];
        
        for(int i=0;i<v;i++) {
            for(int neigh: adj.get(i)) {
                indeg[neigh]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<v;i++) {
            if(indeg[i]==0) q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int neigh: adj.get(node)) {
                if(--indeg[neigh]==0) q.offer(neigh);
            }
        }
        
        if(ans.size()!=v) {
            throw new RuntimeException("The Graph contains the cycle");
        }
        
        return ans;
    }

    public List<Integer> topoSortDfs(int v, List<List<Integer>> adj) {
        boolean vis[] = new boolean[v];
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i=0;i<v;i++) {
            if(!vis[i]) dfs(i, adj, vis, st);
        }
        
        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) {
            res.add(st.pop());
        }
        
        return res;
    }
    
    public void dfs(int node, List<List<Integer>> adj, boolean vis[], Deque<Integer> st) {
        vis[node] = true;
        
        for(int neigh: adj.get(node)) {
            if(!vis[neigh]) dfs(neigh, adj, vis, st);
        }
        
        st.push(node);
    }
}
