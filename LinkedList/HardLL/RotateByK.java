package LinkedList.HardLL;

public class RotateByK {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;

        ListNode temp = head;
        int len = 1;
        while(temp.next!=null) {
            len++;
            temp = temp.next;
        }

        k = k%len;
        if(k==0) return head; 

        //find new head;
        temp.next = head;
        int stepsToNewHead = len-k;
        while(stepsToNewHead-->0){
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        
        return newHead;
    }
}
