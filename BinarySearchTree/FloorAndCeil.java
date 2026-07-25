package BinarySearchTree;

public class FloorAndCeil {
    public int findMaxFork(TreeNode root, int k) {
        TreeNode curr = root;
        int min = -1;

        while(curr!=null) {
            if(curr.val==k) {
                min = curr.val;
                break;
            }else if(curr.val<k) {
                min = curr.val;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return min;
    }

    int findCeil(TreeNode root, int x) {
        TreeNode curr = root;
        int max = 0;

        while(curr!=null) {
            if(curr.val==x) {
                max = curr.val;
                break;
            }else if(curr.val>x) {
                max = curr.val;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return max;
    }
}
