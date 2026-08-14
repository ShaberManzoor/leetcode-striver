package Graphs.MST;

import java.util.HashMap;

public class RemoveStones {
    HashMap<Integer, Integer> parent = new HashMap<>();

    public int findUPar(int x) {
        if (parent.get(x) == x) return x;

        parent.put(x, findUPar(parent.get(x)));
        return parent.get(x);
    }

    public boolean union(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return false;

        parent.put(pu, pv);
        return true;
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10001;

            parent.putIfAbsent(row, row);
            parent.putIfAbsent(col, col);
        }

        int components = parent.size();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10001;

            if (union(row, col)) {
                components--;
            }
        }

        return n - components;
    }
}
