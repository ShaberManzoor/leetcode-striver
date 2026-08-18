package Graphs.OtherAlgo;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class KosarajuAlgorithm {

    // count strong connected Components
    public static int countSCCs(int V, List<List<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        
        //filling vertices in stack according to their finishing time
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfs1(i, adj, vis, st);
            }
        }

        // creating transpose(reverse) graph
        List<List<Integer>> trans = new ArrayList<>();
        for(int i=0;i<V;i++) {
            trans.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++) {
            for(int neigh: adj.get(i)) {
                trans.get(neigh).add(i);
            }
        }

        // processing all the vertice in the order in stack
        Arrays.fill(vis, false);
        int sccCount = 0;

        while(!st.isEmpty()) {
            int node = st.poll();
            if(!vis[node]) {
                dfs2(node, trans, vis);
                sccCount++;
            }
        }

        return sccCount;
    }

    // storing the nodes based on the finish time
    private static void dfs1(int node, List<List<Integer>> adj, boolean[] vis, Deque<Integer> st) {
        vis[node] = true;

        for(int neigh: adj.get(node)) {
            if(!vis[neigh]) {
                dfs1(neigh, adj, vis, st);
            }
        }

        st.push(node);
    }

    //traversal through transpose graph
    private static void dfs2(int node, List<List<Integer>> trans, boolean[] vis) {
        vis[node] = true;

        for(int neigh: trans.get(node)) {
            if(!vis[neigh]) dfs2(neigh, trans, vis);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Building a sample directed graph
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        int totalSCCs = countSCCs(V, adj);
        System.out.println("Total Strongly Connected Components: " + totalSCCs);
    }
}
