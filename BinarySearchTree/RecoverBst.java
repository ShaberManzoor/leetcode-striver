package BinarySearchTree;

public class RecoverBst {
    TreeNode first, second, prev = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    //morris inorder
    public void inorder(TreeNode root) {
        if(root==null) return;
        
        TreeNode curr = root;
        
        while(curr!=null) {
            if(curr.left==null) {
                //checking for current node violation
                if(prev!=null && prev.val>curr.val) {
                    if(first==null) first = prev;
                    
                    second = curr;
                }
                
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left; //inorder predecessor of current node which is rightmost in left subtree
                
                while(pred.right!=null && pred.right!=curr) pred = pred.right;
                
                //no thread found
                if(pred.right==null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    //removing thread
                    pred.right = null;
                    
                    //checking for current node violation
                    if(prev!=null && prev.val>curr.val) {
                        if(first==null) first = prev;
                        
                        second = curr;
                    }
                    
                    //now moving right
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
    }
}
