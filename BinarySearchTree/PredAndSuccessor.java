package BinarySearchTree;

public class PredAndSuccessor {
    public TreeNode predecessor(TreeNode root, int tar) {
        TreeNode curr = root;

        TreeNode min = null;
        while (curr != null) {
            if (curr.val < tar) {
                min = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return min;
    }

    public TreeNode successor(TreeNode root, int tar) {
        TreeNode curr = root;

        TreeNode max = null;
        while (curr != null) {
            if (curr.val > tar) {
                max = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return max;
    }
}
