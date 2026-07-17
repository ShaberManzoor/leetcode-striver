package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if(root==null) return;

        if(root.left!=null) {
            inorder(root.left, res);
        }
        res.add(root.val);
        if(root.right!=null) {
            inorder(root.right, res);
        }
    }
}
