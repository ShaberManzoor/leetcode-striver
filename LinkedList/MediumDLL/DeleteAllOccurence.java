package LinkedList.MediumDLL;

public class DeleteAllOccurence {
    public ListNode deleteAllOccurOfX(ListNode head, int x) {
        // code here
        ListNode temp = head;

        while(temp!=null){
            if(temp.val==x){
                if(temp.prev!=null){
                    temp.prev.next = temp.next;
                }else{
                    head = temp.next;
                }

                if(temp.next!=null){
                    temp.next.prev = temp.prev;
                }
            }

            temp = temp.next;
        }

        return head;
    }
}
