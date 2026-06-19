package LinkedList.HardLL;

import java.util.Stack;

public class MultiLevelDLLFlatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if(head==null) return null;

        Stack<Node> st = new Stack<>();
        Node prev = null;

        st.push(head);

        while(!st.isEmpty()){
            Node curr = st.pop();

            if(prev!=null){
                prev.next = curr;
                curr.prev = prev;
            }

            if(curr.next!=null) st.push(curr.next);

            if(curr.child!=null){
                st.push(curr.child);
                curr.child = null;
            } 

            prev = curr;
        }

        return head;
    }
}
