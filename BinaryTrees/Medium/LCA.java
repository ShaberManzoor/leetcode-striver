package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q); //if p or q lies in left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q); //if p or q lies in right subtree

        //not found in left nor right subtree
        if(left!=null && right!=null) return root;

        return (left!=null) ? left : right;
    }
}
