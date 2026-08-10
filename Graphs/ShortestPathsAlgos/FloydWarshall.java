package Graphs.ShortestPathsAlgos;

public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        // Code here
        int INF = 100000000;
        int n = dist.length;
        
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }
    }
}
