package BinaryTrees.Traversals;

import BinaryTrees.TreeNode;

public class MorrisInorder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        morrisInorder(root);
    }

    public static void morrisInorder(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode pred = curr.left; // rightmost node in left subtree

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // if thread is not found means left subtree is not yet explored
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // thread is found
                    System.out.print(curr.val + " ");
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}
