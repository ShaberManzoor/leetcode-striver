package LinkedList.MediumDLL;

import java.util.ArrayList;

public class SumPairs {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, ListNode head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ListNode left = head, right = head;

        while(right.next!=null){
            right = right.next;
        }

        while(right!=left){
            int sum = left.val + right.val;

            if(sum==target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.val);
                pair.add(right.val);
                ans.add(pair);
            }else if(sum>target){
                right = right.prev;
            }else{
                left = left.next;
            }
        }

        return ans;
    }
}
