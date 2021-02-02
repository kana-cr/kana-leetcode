package 剑指offer;



public class 反转链表 {

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next ==null) return head;
        ListNode pivot = new ListNode(0);
        //设置一个哨兵
        pivot.next = head;
        ListNode ref = head.next;
        ListNode next;
        while(ref!=null){
            pivot.next = ref;
            next = ref.next;
            ref.next = ref;
            ref = next;
        }
        return pivot.next;
    }
}