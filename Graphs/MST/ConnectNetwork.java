package Graphs.MST;

public class ConnectNetwork {

    public static void main(String[] args) {
        ConnectNetwork obj = new ConnectNetwork();
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(obj.makeConnected(n, connections));
    }

    int[] parent;
    public int findUPar(int x) {
        if(x==parent[x]) return x;

        return parent[x] = findUPar(parent[x]);
    }

    public boolean union(int u, int v) {
        int pu = findUPar(u), pv = findUPar(v);

        if(pu==pv) return false;

        parent[pu] = pv;
        return true;
    }

    public int makeConnected(int n, int[][] connections) {
        // not enough connections
        if(n-1>connections.length) return -1;
        
        parent = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;

        int components = n;

        for(int connection[]: connections) {
            int u = connection[0], v = connection[1];

            if(union(u, v)) components--;
        }

        return components-1;
    }
}
