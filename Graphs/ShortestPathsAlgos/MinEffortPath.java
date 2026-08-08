package Graphs.ShortestPathsAlgos;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinEffortPath {
    class Cell {
        int r, c, effort;

        Cell(int r, int c, int effort) {
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }

    public static void main(String[] args) {
        MinEffortPath minEffortPath = new MinEffortPath();

        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };

        int result = minEffortPath.minimumEffortPath(heights);
        System.out.println("Minimum Effort Path: " + result);
    }

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        if (m == 1 && n == 1) return 0;

        int[][] efforts = new int[m][n];

        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<Cell> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.effort, b.effort)
            );

        pq.offer(new Cell(0, 0, 0));

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            int r = curr.r;
            int c = curr.c;
            int currEffort = curr.effort;

            // Outdated entry
            if (currEffort != efforts[r][c]) {
                continue;
            }

            // Destination reached
            if (r == m - 1 && c == n - 1) {
                return currEffort;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Difference between the heights of adjacent cells
                int edgeEffort =
                    Math.abs(heights[r][c] - heights[nr][nc]);

                // Maximum effort encountered on this path
                int newEffort =
                    Math.max(currEffort, edgeEffort);

                if (newEffort < efforts[nr][nc]) {

                    efforts[nr][nc] = newEffort;

                    pq.offer(
                        new Cell(nr, nc, newEffort)
                    );
                }
            }
        }

        return 0;
    }
}
