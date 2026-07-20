package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class DimaterOptimised {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);

        return diameter;
    }

    public int height(TreeNode root) {
        if(root==null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        diameter = Math.max(diameter, lh + rh);

        return Math.max(lh, rh) + 1;
    }
}
