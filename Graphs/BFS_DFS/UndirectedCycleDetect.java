package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Pair {
    int node, par;
    Pair(int node, int par) {
        this.node = node;
        this.par = par;
    }
}

public class UndirectedCycleDetect {
    
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                // if(bfs(i, adj, vis)) return true;
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        
        return false;
    }
    
    public static boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        vis[node] = true;
        
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(node, -1));
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currNode = curr.node;
            int par = curr.par;
            
            for(int neigh: adj.get(currNode)) {
                if(!vis[neigh]) {
                    q.offer(new Pair(neigh, currNode));
                    vis[neigh] = true;
                } else if(neigh!=par) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static boolean dfs(int node, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for(int neigh: adj.get(node)) {
            if(!vis[neigh]) {
                if(dfs(neigh, node, adj, vis)) {
                    return true;
                }
            } else if (neigh != par) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        if (isCycle(V, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}
