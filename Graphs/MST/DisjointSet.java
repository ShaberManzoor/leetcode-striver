package Graphs.MST;

public class DisjointSet {
    int[] parent, rank, size;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // path compression
    public int findUPar(int x) {
        if(x==parent[x]) return x;

        return parent[x] = findUPar(parent[x]);
    }
    
    public void unionByRank(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        
        if(pu==pv) return;
        
        if(rank[pu]<rank[pv]) {
            parent[pu] = pv;
        } else if(rank[pu]>rank[pv]) {
            parent[pv] = pu;
        } else {
            rank[pu]++;
            parent[pv] = pu;
        }
    }
    
    public void unionBySize(int u, int v) {
        int pu = findUPar(u), pv = findUPar(v);
        
        if(pu==pv) return;
        
        if(size[pu]<size[pv]) {
            size[pv] += size[pu];
            parent[pu] = pv;
        } else {
            size[pu] += size[pv];
            parent[pv] = pu;
        }
    }
}
