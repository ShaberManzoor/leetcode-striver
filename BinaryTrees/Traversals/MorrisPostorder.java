package BinaryTrees.Traversals;

import BinaryTrees.TreeNode;

public class MorrisPostorder {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        morrisPostorder(root);
    }

    public static void morrisPostorder(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;

        TreeNode curr = dummy;

        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    printReverse(curr.left, pred);
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    private static void printReverse(TreeNode from, TreeNode to) {
        reverse(from, to);

        TreeNode curr = to;
        while (true) {
            System.out.print(curr.val + " ");
            if (curr == from)
                break;
            curr = curr.right;
        }

        reverse(to, from);
    }

    private static void reverse(TreeNode from, TreeNode to) {
        if (from == to)
            return;

        TreeNode prev = null;
        TreeNode curr = from;
        TreeNode next;

        while (prev != to) {
            next = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
    }
}
