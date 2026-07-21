package BinaryTrees.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import BinaryTrees.TreeNode;

public class RightView {
    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root==null) return res;

        TreeMap<Integer, Integer> tm = new TreeMap<>(); //stores (level, value) pair
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair curr = q.poll();

            tm.put(curr.level, curr.node.val);

            if(curr.node.left!=null) q.offer(new Pair(curr.node.left, curr.level + 1));
            if(curr.node.right!=null) q.offer(new Pair(curr.node.right, curr.level + 1));
        }

        res.addAll(tm.values());

        return res;
    }
}
