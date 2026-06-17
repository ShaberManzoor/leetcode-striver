package LinkedList.MediumLL;

public class IntersectionPoint {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        //the logic is that the p1 covers the distance a + c + b and p2 covers b + c + a;
        while(p1!=p2){
            p1 = (p1==null) ? headB : p1.next;
            p2 = (p2==null) ? headA : p2.next;
        }

        return p1;
    }
}
