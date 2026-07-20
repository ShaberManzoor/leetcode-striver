package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class MaxPathSum {
    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;

        int leftMax = Math.max(0, maxSum(root.left)); //max path sum in left sub tree
        int rightMax = Math.max(0, maxSum(root.right)); //max path sum in right sub tree

        int currPathSum = root.val + leftMax + rightMax;

        globalMax = Math.max(globalMax, currPathSum);

        maxPathSum(root.left);
        maxPathSum(root.right);

        return globalMax;
    }   

    public int maxSum(TreeNode root) {
        if(root==null) return 0;

        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));

        return root.val + Math.max(left, right);
    }
}
