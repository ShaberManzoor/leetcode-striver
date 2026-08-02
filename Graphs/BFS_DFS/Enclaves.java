package Graphs.BFS_DFS;

public class Enclaves {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        Enclaves enclaves = new Enclaves();
        int result = enclaves.numEnclaves(grid);
        System.out.println("Number of enclaves: " + result);
    }
    
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m==1 || n==1) return 0;
        
        for(int i=0;i<m;i++) {
            // first & last row
            if(i==0 || i==m-1) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j]==1) dfs(grid, i, j);
                }
            } else {
                //first col
                if(grid[i][0]==1) dfs(grid, i, 0);
                //last col
                if(grid[i][n-1]==1) dfs(grid, i, n-1);
            }
        }

        // now counting non reachable land cells 
        int enclaves = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) enclaves++;
            }
        }

        return enclaves;
    }
    
    public void dfs(int[][] grid, int r, int c) {
        grid[r][c] = -1;
        
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        
        for(int i=0;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1) dfs(grid, nr, nc);
        }
    }
}
