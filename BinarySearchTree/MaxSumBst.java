package BinarySearchTree;

public class MaxSumBst {
    //contains the Info about binary tree formed by the node
    class NodeInfo {
        boolean isBst;
        int max; //maximum value of all the nodes in the left subtree
        int min; //min value of all the nodes in the right subtree
        int sum; //sum of all the nodes in bst
        
        public NodeInfo(boolean isBst, int max, int min, int sum) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }
    
    int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        dfs(root);

        return maxSum;
    }
    
    public NodeInfo dfs(TreeNode root) {
        if(root==null) {
            return new NodeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        
        NodeInfo left = dfs(root.left);
        NodeInfo right = dfs(root.right);
        
        if(left.isBst && right.isBst && root.val>left.max && root.val<right.min) {
            int sum = left.sum + root.val + right.sum;
            maxSum = Math.max(maxSum, sum);
            
            return new NodeInfo(true, Math.max(root.val, right.max), Math.min(root.val, left.min), sum);
        }
        
        return new NodeInfo(false, 0, 0, 0);
    }
}
