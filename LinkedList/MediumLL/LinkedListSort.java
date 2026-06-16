package LinkedList.MediumLL;

public class LinkedListSort {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode mid = middleNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(rightHead);

        return merge(leftHalf, rightHalf);
    }
    
    public ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode leftHalf, ListNode rightHalf){
        ListNode dummy = new ListNode(0); //for tracking the sorted list head;
        ListNode temp = dummy;

        while(leftHalf!=null && rightHalf!=null){
            if(leftHalf.val <= rightHalf.val){
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
            }else{
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            temp = temp.next;
        }

        temp.next = (leftHalf != null) ? leftHalf : rightHalf;

        return dummy.next;
    }
}
