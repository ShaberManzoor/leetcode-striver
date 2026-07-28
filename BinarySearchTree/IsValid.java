package BinarySearchTree;

public class IsValid {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode node, int min, int max) {
        if(node==null) return true;

        if(node.val<=min || node.val>=max) return false;

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
