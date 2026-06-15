package LinkedList.MediumLL;

public class OddEven {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode odd = head, even = head.next, evenHead = head.next;

        //connecting odd node then even node
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
