package BinaryTrees.Hard;

import java.util.ArrayDeque;
import java.util.Queue;

import BinaryTrees.TreeNode;

public class MaxWidth {
    class Pair {
        long ind;
        TreeNode node;
        Pair(long ind, TreeNode node) {
            this.ind = ind;
            this.node = node;
        }
    }

    int widthOfBinaryTree(TreeNode root) {
        int res = 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, root));

        while(!q.isEmpty()) {
            long firstInd = q.peek().ind; //index of first node 
            int size = q.size();
            long lastInd = firstInd; // index of last node

            for(int i=0;i<size;i++) {
                Pair curr = q.poll();
                long idx = curr.ind - firstInd;
                lastInd = curr.ind-firstInd;

                if(curr.node.left!=null) q.offer(new Pair(2 * idx, curr.node.left));
                if(curr.node.right!=null) q.offer(new Pair(2 * idx+1, curr.node.right));
            }

            res = Math.max(res, (int) lastInd + 1);
        }

        return res;
    }
}
