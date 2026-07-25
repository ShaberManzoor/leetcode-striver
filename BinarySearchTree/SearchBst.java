package BinarySearchTree;

public class SearchBst {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;

        while(curr!=null) {
            if(curr.val==val) break;
            else if(curr.val<val) curr = curr.right;
            else curr = curr.left;
        }

        return curr;
    }
}
