package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest {
    Deque<TreeNode> st = new ArrayDeque<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        TreeNode kthNode = st.peek();

        return kthNode.val;
    }

    public void inorder(TreeNode node, int k) {
        if(st.size()==k) return;

        if(node.left!=null) inorder(node.left, k);

        if(st.size() == k) return;
        st.push(node);
        if(node.right!=null) inorder(node.right, k);
    }
}
