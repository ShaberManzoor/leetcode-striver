package Graphs.ShortestPathsAlgos;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // dist[i][j] = minimum possible maximum height
        // required to reach cell (i, j)
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min heap:
        // [row, col, currentCost]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        dist[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int row = current[0];
            int col = current[1];
            int cost = current[2];

            // If we reached destination, this is optimal
            if (row == n - 1 && col == n - 1) {
                return cost;
            }

            // Ignore outdated heap entries
            if (cost > dist[row][col]) {
                continue;
            }

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                // Cost of path if we move to this cell
                int newCost = Math.max(
                    cost,
                    grid[newRow][newCol]
                );

                // Relaxation
                if (newCost < dist[newRow][newCol]) {

                    dist[newRow][newCol] = newCost;

                    pq.offer(new int[]{
                        newRow,
                        newCol,
                        newCost
                    });
                }
            }
        }

        return -1;
    }
}
