package BinaryTrees.Medium;

import BinaryTrees.TreeNode;

public class IdenticalTrees {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //if both are null
        if(p==null && q==null) return true;

        // if any becomes empty while the other has the node
        if(p==null || q==null) return false;

        if(p.val!=q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
