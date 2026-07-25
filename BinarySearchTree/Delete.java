package BinarySearchTree;

public class Delete {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val<key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val>key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            TreeNode max = getMaxValNode(root.left);
            root.val = max.val;
            
            root.left = deleteNode(root.left, max.val);
        }

        return root;
    }

    public TreeNode getMaxValNode(TreeNode node) {
        while(node.right!=null) node = node.right;

        return node;
    }
}
