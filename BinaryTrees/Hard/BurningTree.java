package BinaryTrees.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import BinaryTrees.TreeNode;

public class BurningTree {
    Map<TreeNode, TreeNode> parentMap;
    TreeNode targetNode;

    public int minTime(TreeNode root, int target) {
        parentMap = new HashMap<>();

        buildParent(root, null, target);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetNode);

        Set<TreeNode> vis = new HashSet<>();
        vis.add(targetNode);

        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;

            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();

                if(curr.left!=null && vis.add(curr.left)) {
                    q.offer(curr.left);
                    spread = true;
                } 
                if(curr.right!=null && vis.add(curr.right)) {
                    q.offer(curr.right);
                    spread = true;
                } 

                TreeNode par = parentMap.get(curr);

                if(par!=null && vis.add(par)) {
                    q.offer(par);
                    spread = true;
                } 
            }

            if(spread) time++;
        }

        return time;   
    }

    void buildParent(TreeNode node, TreeNode par, int target) {
        if(node==null) return;
        
        parentMap.put(node, par);
        if(node.val==target) targetNode = node;

        buildParent(node.left, node, target);
        buildParent(node.right, node, target);
    }
}
