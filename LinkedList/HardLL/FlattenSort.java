package LinkedList.HardLL;

public class FlattenSort {
    class ListNode {
        int val;
        ListNode next, bottom;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next, ListNode bottom) {
            this.val = val;
            this.next = next;
            this.bottom = bottom;
        }
    }

    ListNode flatten(ListNode head) {
        if(head==null || head.next==null) return head;
        
        head.next = flatten(head.next);

        return merge(head, head.next);
    }

    ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(a!=null && b!=null){
            if(a.val<=b.val){
                curr.next = a;
                a = a.bottom;
            }else{
                curr.next = b;
                b = b.bottom;
            }

            curr = curr.bottom;
            curr.next = null;
        }

        return dummy.next;
    }
}
