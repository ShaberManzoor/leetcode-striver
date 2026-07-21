package BinaryTrees.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import BinaryTrees.TreeNode;

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                //means last list added is from left to right
                if((res.size()&1)==1) {
                    temp.add(0, curr.val);
                }else{
                    temp.add(curr.val);    
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }

            res.add(temp);
        }

        return res;
    }
}
