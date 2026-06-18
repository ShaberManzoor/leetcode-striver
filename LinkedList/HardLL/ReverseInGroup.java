package LinkedList.HardLL;

public class ReverseInGroup {
 private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 1) {
            start = start.next;
            k--;
        }
        return start;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevTail = dummy;
        ListNode curr = head;

        while (curr != null) {

            ListNode kthNode = getKthNode(curr, k);

            if (kthNode == null)
                break;

            ListNode nextGroup = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(curr);

            prevTail.next = newHead;

            // curr becomes tail after reversal
            curr.next = nextGroup;

            prevTail = curr;
            curr = nextGroup;
        }

        return dummy.next;
    }
}
