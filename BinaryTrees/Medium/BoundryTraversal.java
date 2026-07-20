package BinaryTrees.Medium;

import java.util.ArrayList;

import BinaryTrees.TreeNode;

public class BoundryTraversal {
    ArrayList<Integer> res;

    ArrayList<Integer> boundaryTraversal(TreeNode node) {
        res = new ArrayList<>();

        res.add(node.val);
        addLeftBoundry(node.left);
        addLeafNodes(node.left); //of left subtree
        addLeafNodes(node.right); //of right subtree
        addRightBoundry(node.right);

        return res;
    }

    public void addLeftBoundry(TreeNode node) {
        if(node==null) return;

        if(node.left!=null) {
            res.add(node.val);
            addLeftBoundry(node.left);
        }else if(node.right!=null) {
            res.add(node.val);
            addLeftBoundry(node.right);
        }
    }

    public void addLeafNodes(TreeNode node) {
        if(node==null) return;

        addLeafNodes(node.left);
        if(node.left==null && node.right==null) {
            res.add(node.val);
        }
        addLeafNodes(node.right);
    }

    public void addRightBoundry(TreeNode node) {
        if(node==null) return;

        if(node.right!=null) {
            addRightBoundry(node.right);
            res.add(node.val);
        } else if(node.left!=null) {
            addRightBoundry(node.left);
            res.add(node.val);
        }
    }
}
