package Graphs.ShortestPathsAlgos;

public class MinNeighbours {
    public int findTheCity(int n, int edges[][], int distanceThreshold) {
        int INF = 1_000_000_000;
        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dist[i][j] = i==j ? 0 : INF;
            }
        }

        for(int edge[]: edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(dist[i][k]!=INF && dist[k][j]!=INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int ans = -1, minCount = INF;

        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(i!=j && dist[i][j]<distanceThreshold) {
                    count++;
                }
            }

            if(count<=minCount) {
                minCount = count;
                ans = i;
            }
        }

        return ans;
    }
}
