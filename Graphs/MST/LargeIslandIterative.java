package Graphs.MST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargeIslandIterative {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        Map<Integer, Integer> islandSize = new HashMap<>();

        int maxArea = 0;
        int islandId = 2;

        // Label all islands and calculate their sizes
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(r, c, islandId, grid);

                    islandSize.put(islandId, size);
                    maxArea = Math.max(maxArea, size);

                    islandId++;
                }
            }
        }

        // Try converting every 0 into 1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] != 0) {
                    continue;
                }

                int size = 1;

                // To avoid counting the same island multiple times
                Set<Integer> uniqueIslands = new HashSet<>();

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }

                    int currIslandId = grid[nr][nc];

                    if (currIslandId > 1 &&
                        uniqueIslands.add(currIslandId)) {

                        size += islandSize.get(currIslandId);
                    }
                }

                maxArea = Math.max(maxArea, size);
            }
        }

        return maxArea;
    }

    public int dfs(int r, int c, int islandId, int[][] grid) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = islandId;

        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            size += dfs(nr, nc, islandId, grid);
        }

        return size;
    }
}
