package LinkedList.MediumLL;

public class Palindrome {
    boolean isPalindrome(ListNode head){
        if(head==null || head.next==null) return true;

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reversing the String from middle to last
        ListNode prev = null;
        while(slow!=null){
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        slow = head;

        //now comparing the two halfs
        while(prev!=null){
            if(prev.val!=slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }
}
