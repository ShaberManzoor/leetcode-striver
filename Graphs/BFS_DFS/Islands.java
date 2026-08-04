package Graphs.BFS_DFS;

public class Islands {
    public int[] dr = { -1, 0, 1, 0 };
    public int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        Islands is = new Islands();
        System.out.println("Number of Islands: " + is.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length, n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(char grid[][], int r, int c) {
        grid[r][c] = '2';

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1')
                dfs(grid, nr, nc);
        }
    }
}
