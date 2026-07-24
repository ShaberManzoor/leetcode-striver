package BinaryTrees.Hard;

import BinaryTrees.TreeNode;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        //means perfect BT
        if(lh==rh) return (1<<lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //to find height from the left most path
    public int leftHeight(TreeNode node) {
        int height = 0;

        while(node!=null) {
            height++;
            node = node.left;
        }

        return height;
    }

    //to find height from the right most path
    public int rightHeight(TreeNode node) {
        int height = 0;

        while(node!=null) {
            height++;
            node = node.right;
        }

        return height;
    }
}
