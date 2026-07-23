package BinaryTrees.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import BinaryTrees.TreeNode;

public class KDistanceNodes {
Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        buildParent(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) {
                List<Integer> ans = new ArrayList<>();

                while (!queue.isEmpty()) {
                    ans.add(queue.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                if (curr.left != null && visited.add(curr.left))
                    queue.offer(curr.left);

                if (curr.right != null && visited.add(curr.right))
                    queue.offer(curr.right);

                TreeNode par = parent.get(curr);

                if (par != null && visited.add(par))
                    queue.offer(par);
            }

            distance++;
        }

        return new ArrayList<>();
    }

    private void buildParent(TreeNode node, TreeNode par) {

        if (node == null)
            return;

        parent.put(node, par);

        buildParent(node.left, node);

        buildParent(node.right, node);
    }
}
