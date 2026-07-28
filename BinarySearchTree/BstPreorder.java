package BinarySearchTree;

public class BstPreorder {
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int preorder[], int min, int max) {
        if(idx==preorder.length) return null;

        int val = preorder[idx];

        if(val<=min || val>=max) return null;
        idx++;

        TreeNode root = new TreeNode(val);

        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }
}
