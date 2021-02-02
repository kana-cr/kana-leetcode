package 剑指offer;

public class 两个链表的第一个公共节点 {

    public ListNode getIntersectionNode_vol(ListNode headA, ListNode headB) {
        while(headA != null){
            ListNode cur = headB;
            while(cur != null){
                if(headA == cur) return headA;
                cur = cur.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while(h1 != h2){
           h1 = h1 == null?headB:h1.next;
           h2 = h2 == null?headA:h2.next;
        }
        return h1;
    }

}