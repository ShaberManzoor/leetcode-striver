package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int time = 0;
        int freshOranges = 0;
        
        Queue<int[]> q = new ArrayDeque<>(); // to store the x, y coordinates of rooten orange
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) {
                    // will add the rotten orange
                    q.offer(new int[]{i, j});
                } else if(grid[i][j]==1) {
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges==0) return 0;
        if(q.isEmpty()) return -1; // if there are no rotten oranges which will rotten the fresh orange then not possible
        
        int x[] = {0, 1, 0, -1};
        int y[] = {1, 0, -1, 0};
        
        while(!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            
            for(int j=0;j<size;j++) {
                int curr[] = q.poll(); //index of curr rotten orange
                
                for(int i=0;i<4;i++) {
                    int neighX = curr[0] + x[i]; //x neighbour coordinate
                    int neighY = curr[1] + y[i]; // y neighbour cooridnate
                    
                    if(neighX>=0 && neighX<m && neighY>=0 && neighY<n && grid[neighX][neighY]==1) {
                        q.offer(new int[]{neighX, neighY});
                        grid[neighX][neighY] = 2;
                        freshOranges--;
                        rotted = true;
                    }
                }
            }
            
            if(rotted) time++;
        }
        
        return freshOranges==0 ? time : -1;
    }
}
