package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Nearest1 {
    class Cell {
        int row, col, dis;
        
        Cell (int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];
        
        Queue<Cell> q = new ArrayDeque<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    q.offer(new Cell(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            Cell curr = q.poll();
            int r = curr.row, c = curr.col, d = curr.dis;
            
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    
                    if(nr>=0 && nr<m && nc>=0 && nc<n && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        ans[nr][nc] = d + 1;
                        q.offer(new Cell(nr, nc, d + 1));
                    }
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                row.add(ans[i][j]);
            }

            dist.add(row);
        }

        return dist;
    }
}
