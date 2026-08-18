package Graphs.OtherAlgo;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class TarjansAlgorithm {
    private static int timer;
    private static int[] disc; // discovery time of node u
    private static int[] low; // The earliest discovered vertex that u or something reachable from u can reach using dfs/ backedge
    private static List<List<Integer>> sccs;
    private static Deque<Integer> st;
    private static boolean[] instack;

    public static List<List<Integer>> findSCCs(int V, List<List<Integer>> adj) {
        timer = 0;
        disc = new int[V];
        low = new int[V];
        sccs = new ArrayList<>();
        st = new ArrayDeque<>();
        instack = new boolean[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for(int i=0;i<V;i++) {
            if(disc[i]==-1) dfs(i, adj);
        }

        return sccs;
    }

    public static  void dfs(int u, List<List<Integer>> adj) {
        disc[u] = low[u] = timer++;
        st.push(u);
        instack[u] = true;

        for(int v: adj.get(u)) {
            if(disc[v]==-1) {
                dfs(v, adj);
                low[u] = Math.min(low[u], low[v]);
            } else if (instack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if(low[u]==disc[u]) {
            List<Integer> scc = new ArrayList<>();
            while(true) {
                int node = st.pop();
                instack[node] = false;
                scc.add(node);
                if(node==u) break;
            }

            sccs.add(scc);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Building sample graph
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        List<List<Integer>> sccs = findSCCs(V, adj);
        
        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }
}
