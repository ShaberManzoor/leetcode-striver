package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

public class PreOrder {
    private List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();

        preorder(root);

        return res;
    }

    public void preorder(TreeNode root) {
        if(root==null) return;

        res.add(root.val);
        if(root.left!=null) {
            preorder(root.left);
        }
        if(root.right!=null) {
            preorder(root.right);
        }
    }
}
