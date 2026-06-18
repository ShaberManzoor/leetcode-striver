package LinkedList.MediumDLL;

public class RemoveDuplicates {
    ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;

            // Skip duplicate nodes
            while (nextNode != null && nextNode.val == curr.val) {
                nextNode = nextNode.next;
            }

            curr.next = nextNode;

            if (nextNode != null) {
                nextNode.prev = curr;
            }

            curr = nextNode;
        }

        return head;
    }
}
