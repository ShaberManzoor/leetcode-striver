package BinaryTrees.Traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import BinaryTrees.TreeNode;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);

                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }

            res.add(temp);
        }

        return res;
    }
}
