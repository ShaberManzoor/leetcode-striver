package Graphs.MST;

public class SwimRisingWater {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n]; 
            size = new int[n];

            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int x) {
            if(x==parent[x]) return x;

            return parent[x] = findParent(parent[x]);
        }

        void union(int u, int v) {
            int pu = findParent(u), pv = findParent(v);

            //already belongs to same component
            if(pu==pv) return;

            if(size[pu]<size[pv]) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }

            parent[pv] = pu;
            size[pu] += size[pv];
        }

        boolean connected(int u, int v) {
            return parent[u]==parent[v];
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int total = n*n;

        DSU dsu = new DSU(total);
        int position[] = new int[total];

        for(int r=0;r<n;r++) {
            for(int c=0;c<n;c++) {
                position[grid[r][c]] = r*n + c;
            }
        }

        boolean active[] = new boolean[total];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int time=0;time<total;time++) {
            //cell with height = time
            int cell = position[time];

            int r = cell / n, c = cell % n;

            active[cell] = true;

            for(int i=0;i<4;i++) {
                int nr = r + dr[i], nc = c + dc[i];

                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
                
                int neighbour = nr * n + nc;

                if(active[neighbour]) {
                    dsu.union(cell, neighbour);
                }
            }

            if(dsu.connected(0, total-1)) return time;
        }

        return -1;
    }
}
