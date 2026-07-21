package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode node1, TreeNode node2) {
        if(node1==null && node2==null) return true;

        if(node1==null || node2==null || node1.val!=node2.val) return false;

        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }
}
