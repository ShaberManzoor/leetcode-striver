package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public boolean findTarget(TreeNode root, int k) {
        //inorder of bst (since its sorted)
        List<Integer> inorderArr = new ArrayList<>();
        
        inorder(root, inorderArr);
        
        int i = 0, j = inorderArr.size()-1;
        while(i<j) {
            int sum = inorderArr.get(i) + inorderArr.get(j);
            if(sum==k) {
                return true;
            } else if(sum>k) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
    }
    
    public void inorder(TreeNode node, List<Integer> arr) {
        if(node==null) return;
        
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }
}
