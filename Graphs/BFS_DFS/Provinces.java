package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Provinces {
    private int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                bfs(isConnected, city, visited);
                provinces++;
            }
        }

        return provinces;
    }

    public void bfs(int[][] isConnected, int city, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(city);
        visited[city] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neigh = 0; neigh < isConnected.length; neigh++) {
                if (isConnected[curr][neigh] == 1 && !visited[neigh]) {
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }
    }

    public void dfs(int[][] isConnected, int city, boolean visited[]) {
        visited[city] = true;

        for (int neigh = 0; neigh < isConnected.length; neigh++) {
            if (isConnected[city][neigh] == 1 && !visited[neigh])
                dfs(isConnected, neigh, visited);
        }
    }
}
