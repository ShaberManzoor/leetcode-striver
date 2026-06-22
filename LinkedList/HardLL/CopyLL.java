package LinkedList.HardLL;

public class CopyLL {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null) return head;
        
        //creating and adding the nodes in between
        Node curr = head;
        while(curr!=null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        //Now assigning random pointers
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        //seperating list
        Node dummy = new Node(-1);
        curr = head;
        Node currCopy = dummy;

        while(curr!=null){
            Node copy = curr.next;
            curr.next = copy.next;

            currCopy.next = copy;
            currCopy = copy;

            curr = curr.next; 
        }

        return dummy.next;
    }
}
