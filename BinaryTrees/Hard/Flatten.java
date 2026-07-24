package BinaryTrees.Hard;

import BinaryTrees.TreeNode;

public class Flatten {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr!=null) {
            if(curr.left!=null) {
                TreeNode pre = curr.left;

                //right most in left subtree
                while(pre.right!=null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}
