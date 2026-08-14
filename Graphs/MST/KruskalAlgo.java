package Graphs.MST;

import java.util.Arrays;

public class KruskalAlgo {
    int[] parent, size;
	
	public int findUPar(int x) {
	    if(parent[x]==x) return x;
	    
	    return parent[x] = findUPar(parent[x]);
	}
	
	public boolean unionBySize(int u, int v) {
	    int pu = findUPar(u), pv = findUPar(v);
	    
	    //belong to same component
	    if(pu==pv) return false;
	    
	    if(size[pu]<size[pv]) {
	        size[pv] += size[pu];
	        parent[pu] = pv;
	    } else {
	        size[pu] += size[pv];
	        parent[pv] = pu;
	    }
	    
	    return true;
	}
	
	public int spanningTree(int V, int[][] edges) {
	    parent = new int[V];
	    size = new int[V];
	    
	    for(int i=0;i<V;i++) {
	        parent[i] = i;
	        size[i] = 1;
	    }
	    
	    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
	    
	    int minWt = 0, edgesUsed = 0;
	    
	    for(int edge[]: edges) {
	        int u = edge[0], v = edge[1], w = edge[2];
	        
	        if(unionBySize(u, v)) {
	            minWt += w;
	            edgesUsed++;
	            
	            if(edgesUsed==V-1) break;
	        }
	    }
	    
	    return minWt;
	}
}
