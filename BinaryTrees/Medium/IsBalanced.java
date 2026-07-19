package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }

    public int depth(TreeNode root) {
        if(root==null) return 0;

        int lh = depth(root.left);
        if(lh==-1) return -1;

        int rh = depth(root.right);
        if(rh==-1) return -1;

        if(Math.abs(rh-lh)>1) return -1;

        return Math.max(lh, rh) + 1;
    }
}
