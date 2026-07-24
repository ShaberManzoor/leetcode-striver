package BinaryTrees.Hard;

import java.util.HashMap;
import java.util.Map;

import BinaryTrees.TreeNode;

public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();
    private int preInd;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //storing the index of each node
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1);
    }

    public TreeNode build(int preorder[], int left, int right) {
        if(left>right) return null;

        int rootVal = preorder[preInd++];
        TreeNode root = new TreeNode(rootVal);
        
        int mid = map.get(rootVal);

        root.left = build(preorder, left, mid-1);
        root.right = build(preorder, mid+1, right);

        return root;
    }
}
