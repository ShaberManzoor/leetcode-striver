package Graphs.ShortestPathsAlgos;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryMaze {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        
        Queue<int[]> q = new ArrayDeque<>(); // to store the (x, y) coordinates of node
        q.offer(new int[]{0, 0});
        grid[0][0] = 1; // distance from src to itself
        
        int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            int r = curr[0], c = curr[1];
            if(r==m-1 && c==n-1) return grid[r][c];
            
            for(int i=0;i<8;i++) {
                int nr = r + dr[i], nc = c + dc[i];
                
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0) {
                    grid[nr][nc] = grid[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                } 
            }
        }
        
        return -1;
    }
}
