package BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;

import BinaryTrees.TreeNode;

public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorder(root, res);

        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        if (root.left != null) {
            postorder(root.left, res);
        }
        if (root.right != null) {
            postorder(root.right, res);
        }
        res.add(root.val);
    }
}
