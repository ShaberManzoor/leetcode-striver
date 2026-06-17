package LinkedList.MediumLL;

public class AddOne {
    public ListNode addOne(ListNode head) {
        head = reverse(head);

        //adding one from head 
        int carry = 1;
        ListNode curr = head;
        while(curr!=null && carry==1){
            int sum = curr.val + 1;
            curr.val = sum % 10;
            carry = sum/10;

            if(curr.next==null && carry>1){
                curr.next = new ListNode(carry);
                carry = 0;
            }

            curr = curr.next;
        }

        return reverse(head);
    }

    public ListNode reverse(ListNode head){
        ListNode temp = head, prev = null;

        while(temp!=null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}
