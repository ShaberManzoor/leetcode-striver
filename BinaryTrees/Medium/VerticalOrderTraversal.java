package BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BinaryTrees.TreeNode;

public class VerticalOrderTraversal {
    class NodeInfo {
        int row, col, val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> list = new ArrayList<>();

        dfs(root, 0, 0, list);

        //now sorting the list of nodes
        Collections.sort(list, (a, b) -> {
            if(a.col!=b.col) {
                return a.col-b.col;
            }

            if(a.row!=b.row) {
                return a.row - b.row;
            }

            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for(NodeInfo node: list) {
            if(prevCol!=node.col) {
                res.add(new ArrayList<>());
                prevCol = node.col;
            }

            res.get(res.size()-1).add(node.val);
        }

        return res;
    }

    //we need to travel we can use bfs, inorder, preorder, post order any thing
    public void dfs(TreeNode root, int row, int col, List<NodeInfo> list) {
        if(root==null) return;

        NodeInfo curr = new NodeInfo(row, col, root.val);
        list.add(curr);

        if(root.left!=null) dfs(root.left, row+1, col-1, list);
        if(root.right!=null) dfs(root.right, row+1, col+1, list);
    }
}
