package Graphs.ShortestPathsAlgos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class CheapestFlight {
    class Tuple {
        int node;
        int cost;
        int flightsUsed;

        Tuple(int node, int cost, int flightsUsed) {
            this.node = node;
            this.cost = cost;
            this.flightsUsed = flightsUsed;
        }
    }

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        // Build graph
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj.get(u).add(new int[]{v, price});
        }

        int INF = Integer.MAX_VALUE / 2;

        int[] costs = new int[n];
        Arrays.fill(costs, INF);

        costs[src] = 0;

        Queue<Tuple> q = new ArrayDeque<>();
        q.offer(new Tuple(src, 0, 0));

        // k stops = k + 1 flights
        while (!q.isEmpty()) {

            int size = q.size();

            // Costs before this level
            int[] nextCosts = costs.clone();

            for (int i = 0; i < size; i++) {

                Tuple curr = q.poll();

                int node = curr.node;
                int cost = curr.cost;
                int flightsUsed = curr.flightsUsed;

                // At most k + 1 flights
                if (flightsUsed == k + 1) {
                    continue;
                }

                for (int[] edge : adj.get(node)) {

                    int nextNode = edge[0];
                    int price = edge[1];

                    int newCost = cost + price;

                    if (newCost < nextCosts[nextNode]) {

                        nextCosts[nextNode] = newCost;

                        q.offer(
                            new Tuple(
                                nextNode,
                                newCost,
                                flightsUsed + 1
                            )
                        );
                    }
                }
            }

            costs = nextCosts;
        }

        return costs[dst] == INF ? -1 : costs[dst];
    }
}
