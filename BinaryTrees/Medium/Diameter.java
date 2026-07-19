package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class Diameter {

    //it will take O(n^2) complexity because we travel O(n) for each node

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        int lh = depth(root.left);
        int rh = depth(root.right);

        int rootDiameter = lh + rh;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiamter = diameterOfBinaryTree(root.right);

        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiamter));
    }

    public int depth(TreeNode root) {
        if(root==null) return 0;

        int lh = depth(root.left);
        int rh = depth(root.right);

        return Math.max(lh, rh) + 1;
    }
}
