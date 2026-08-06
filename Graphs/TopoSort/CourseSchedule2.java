package Graphs.TopoSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int p[]: prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        
        int state[] = new int[numCourses];
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i=0;i<numCourses;i++) {
            if(state[i]==0) {
                if(hasCycle(i, adj, state, st)) return new int[0];
            }
        }
        
        int res[] = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            res[i] = st.pop();
        }
        
        return res;
    }
    
    //dfs for cycle detection
    public boolean hasCycle(int node, List<List<Integer>> adj, int state[], Deque<Integer> st) {
        if(state[node]==2) return false;
        if(state[node]==1) return true;
        
        state[node] = 1; //processing
        
        for(int neigh: adj.get(node)) {
            if(hasCycle(neigh, adj, state, st)) return true;
        }
        
        state[node] = 2; //visited
        st.push(node);
        
        return false;
    }
}
