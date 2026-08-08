package Graphs.ShortestPathsAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraAlgo {

    class Pair {
        int node, dis;

        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {

        // Graph build
        Map<Integer, Set<Pair>> adj = new HashMap<>();

        for (int i = 0; i < V; i++) {
            adj.put(i, new HashSet<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        ArrayList<Integer> dis =
            new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));

        dis.set(src, 0);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.dis - b.dis);

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int wt = curr.dis;

            // Skip outdated entry
            if (wt != dis.get(node)) {
                continue;
            }

            for (Pair neigh : adj.get(node)) {

                // Current distance + edge weight
                int newDis = wt + neigh.dis;

                // Relaxation
                if (newDis < dis.get(neigh.node)) {

                    dis.set(neigh.node, newDis);

                    pq.offer(new Pair(neigh.node, newDis));
                }
            }
        }

        return dis;
    }
}