package BinaryTrees.Traversals;

import BinaryTrees.TreeNode;

public class MorrisPreorder {
        public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        morrisPreorder(root);
    }

    public static void morrisPreorder(TreeNode root) {
        TreeNode curr = root;

        while(curr!=null) {
            if(curr.left==null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            }else{
                TreeNode pred = curr.left; //right most node on the left subtree

                while(pred.right!=null && pred.right!=curr) {
                    pred = pred.right;
                }

                // Thread does not exist means the left subt tree is not yet explore
                if(pred.right==null) {
                    System.out.print(curr.val + " ");
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    //left sub tree is explored thread exists
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}
