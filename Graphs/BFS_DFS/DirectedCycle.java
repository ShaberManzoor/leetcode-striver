package Graphs.BFS_DFS;

import java.util.ArrayList;

public class DirectedCycle {
    public boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                if(dfs(i, adj, vis, pathVis)) return true;;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        
        for(int neigh: adj.get(node)) {
            if(!vis[neigh]) {
                if(dfs(neigh, adj, vis, pathVis)) return true;
            } else if(pathVis[neigh]) return true;
        }
        
        pathVis[node] = false;
        return false;
    }
}
