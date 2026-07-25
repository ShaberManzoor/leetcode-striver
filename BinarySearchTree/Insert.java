package BinarySearchTree;

public class Insert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);

        if(root==null) return node;

        TreeNode curr = root;
        while(curr!=null) {
            if(curr.val>val) {
                if(curr.left==null) {
                    curr.left = node;
                    break;
                }
                curr = curr.left;
            } else {
                if(curr.right==null) {
                    curr.right = node;
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }
}
