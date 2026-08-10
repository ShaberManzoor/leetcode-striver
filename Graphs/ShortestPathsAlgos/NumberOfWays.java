package Graphs.ShortestPathsAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class NumberOfWays {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Roads are bidirectional
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int t = road[2];

            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        // {node, distance}
        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        pq.offer(new long[]{0, 0});

        long[] dis = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dis, Long.MAX_VALUE);

        dis[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            int u = (int) curr[0];
            long d = curr[1];

            // Outdated entry
            if (d > dis[u]) {
                continue;
            }

            for (int[] neigh : graph.get(u)) {

                int v = neigh[0];
                int wt = neigh[1];

                long newDis = d + wt;

                // Found a shorter path
                if (newDis < dis[v]) {
                    dis[v] = newDis;
                    ways[v] = ways[u];

                    pq.offer(new long[]{v, newDis});
                }

                // Found another shortest path
                else if (newDis == dis[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    } 
}
