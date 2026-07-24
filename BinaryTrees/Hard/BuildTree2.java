package BinaryTrees.Hard;

import java.util.HashMap;
import java.util.Map;

import BinaryTrees.TreeNode;

public class BuildTree2 {
    Map<Integer, Integer> map = new HashMap<>();
    private int postInd;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //storing the index of each node
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }

        postInd = postorder.length-1;

        return build(postorder, 0, postInd);
    }

    public TreeNode build(int postorder[], int left, int right) {
        if(left>right) return null;

        int rootVal = postorder[postInd--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.right = build(postorder, mid+1, right);
        root.left = build(postorder, left, mid-1);

        return root;
    }
}
