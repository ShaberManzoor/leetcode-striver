package BinaryTrees.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

import BinaryTrees.TreeNode;

public class BottomView {
    class Pair {
        TreeNode node;
        int hd;

        Pair(int hd, TreeNode node) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if(root==null) return res;

        Queue<Pair> q = new ArrayDeque<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            map.put(curr.hd, curr.node.val);

            if(curr.node.left!=null) q.offer(new Pair(curr.hd-1, curr.node.left));
            if(curr.node.right!=null) q.offer(new Pair(curr.hd+1, curr.node.right));
        }

        res.addAll(map.values());

        return res;
    }
}
