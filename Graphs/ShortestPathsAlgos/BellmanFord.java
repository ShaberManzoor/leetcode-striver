package Graphs.ShortestPathsAlgos;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int INF = 100000000;

        ArrayList<Integer> dis = new ArrayList<>();

        // Initialize distances
        for (int i = 0; i < V; i++) {
            dis.add(INF);
        }

        dis.set(src, 0);

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dis.get(u) != INF &&
                    dis.get(u) + wt < dis.get(v)) {

                    dis.set(v, dis.get(u) + wt);
                    updated = true;
                }
            }

            if (!updated) {
                break;
            }
        }

        // Check for negative-weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dis.get(u) != INF &&
                dis.get(u) + wt < dis.get(v)) {

                return new ArrayList<>(Arrays.asList(-1));
            }
        }

        return dis;
    }
}
