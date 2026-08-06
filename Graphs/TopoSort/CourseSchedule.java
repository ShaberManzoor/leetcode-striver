package Graphs.TopoSort;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] p : prerequisites)
            adj.get(p[1]).add(p[0]);

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adj, state))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {

        state[node] = 1; // visiting

        for (int next : adj.get(node)) {

            if (state[next] == 1)
                return true;

            if (state[next] == 0 && hasCycle(next, adj, state))
                return true;
        }

        state[node] = 2; // processed
        return false;
    }
}
