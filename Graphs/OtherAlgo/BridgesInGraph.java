package Graphs.OtherAlgo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class BridgesInGraph {
    private int timer = 0;
    private int[] disc, low;
    private List<List<Integer>> graph;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        graph = new ArrayList<>();
        graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            disc[i] = -1;
            low[i] = -1;
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge: connections) {
            int u = edge.get(0), v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0;i<n;i++) {
            if(disc[i]==-1) {
                dfs(i, -1);
            }
        }

        return bridges;
    }

    public void dfs(int u, int parent) {
        low[u] = disc[u] = timer++;

        for(int v: graph.get(u)) {

            //parent edge
            if(v==parent) continue;

            if(disc[v]==-1) {
                dfs(v, u);

                low[u] = Math.min(low[u], low[v]);

                //bridge condition
                if(low[v]>disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                //back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
