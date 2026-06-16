package LinkedList.MediumLL;

public class LinkedListOf0s1s2s {
    public ListNode segregate(ListNode head) {
        if(head.next==null) return head;

        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);

        ListNode zeroTail = zeroDummy;
        ListNode oneTail = oneDummy;
        ListNode twoTail = twoDummy;

        ListNode temp = head;
        while(temp!=null){
            if(temp.val==0){
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            }else if(temp.val==1){
                oneTail.next = temp;
                oneTail = oneTail.next;
            }else{
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
        }

        zeroTail.next = (oneDummy.next!=null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;
        
        return zeroDummy.next;
    }
}
