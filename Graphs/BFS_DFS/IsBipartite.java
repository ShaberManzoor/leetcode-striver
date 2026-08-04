package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i=0;i<n;i++) {
            if(colors[i]==-1 && !bfs(graph, i, 0, colors)) return false;
        }
        
        return true;
    }
    
    public boolean bfs(int[][] graph, int node, int color, int[] colors) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        colors[node] = color;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                for(int neigh: graph[curr]) {
                    if(colors[neigh]==-1) {
                        colors[neigh] = 1-colors[curr];
                        q.offer(neigh);
                    } else if(colors[neigh]==colors[curr]) return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph, int node, int color, int[] colors) {
        colors[node] = color;
        
        for(int neigh: graph[node]) {
            if(colors[neigh]==-1) {
                if(!dfs(graph, neigh, 1-color, colors)) return false;
            } else if(colors[neigh]==color) return false;
        }
        
        return true;
    }
}