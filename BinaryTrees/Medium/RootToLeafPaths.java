package BinaryTrees.Medium;

import java.util.ArrayList;

import BinaryTrees.TreeNode;

public class RootToLeafPaths {
    public ArrayList<ArrayList<Integer>> paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        preorder(root, res, new ArrayList<>());

        return res;
    }

    public void preorder(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if(root==null) return;

        temp.add(root.val);

        if(root.left==null && root.right==null) {
            res.add(new ArrayList<>(temp));
        } else {
            preorder(root.left, res, temp);
            preorder(root.right, res, temp);
        }

        temp.remove(temp.size()-1);
    }
}
