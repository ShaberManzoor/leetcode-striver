package Graphs.MST;

import java.util.HashSet;

public class MakingLargeIsland {
    int[] parent, size;

    public int findPar(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = findPar(parent[x]);
    }

    public void union(int u, int v) {
        int pu = findPar(u), pv = findPar(v);
        if (pu == pv)
            return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            size[pu] += size[pv];
            parent[pv] = pu;
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        parent = new int[n * n];
        size = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 };

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0)
                    continue;

                int cell = r * n + c;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                        continue;

                    if(grid[nr][nc]==1) {
                        int neigh = nr * n + nc;
                        union(cell, neigh);
                    }
                }
            }
        }
        
        int maxArea = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int cell = r * n + c;
                    int root = findPar(cell);
                    maxArea = Math.max(maxArea, size[root]);
                    continue;
                }

                int newSize = 1;
                HashSet<Integer> neighsRoot = new HashSet<>();

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                        continue;

                    if(grid[nr][nc]==1) {
                        int neigh = nr * n + nc;
                        int neighRoot = findPar(neigh);
                        neighsRoot.add(neighRoot);
                    }
                }

                for (int neighRoot : neighsRoot) {
                    newSize += size[neighRoot];
                }

                maxArea = Math.max(newSize, maxArea);
            }
        }

        return maxArea;
    }
}
