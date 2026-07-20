package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class MaxPathSumOptimised {
// Global variable to keep track of the maximum path sum found so far
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateGain(root);
        return maxPathSum;
    }

    private int calculateGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 1. Recursively get the max path sum from left and right subtrees
        // If the path sum is negative, we ignore it by taking Math.max(0, ...)
        int leftGain = Math.max(0, calculateGain(node.left));
        int rightGain = Math.max(0, calculateGain(node.right));

        // 2. Price of the current path: check if this node is the "top" of the max path
        int currentPathSum = node.val + leftGain + rightGain;

        // 3. Update the global maximum if the current path is better
        maxPathSum = Math.max(maxPathSum, currentPathSum);

        // 4. Return the maximum gain this node can contribute to its parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
