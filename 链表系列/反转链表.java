package 链表系列;

public class 反转链表 {
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode cur = head.next;
        ListNode pre = head;
        head.next = null;
        while (cur.next != null){
            ListNode node = cur.next;
            ListNode tmp = cur;
            cur.next = pre;
            pre = tmp;
            cur = node;
        }
        cur.next = pre;
        return cur;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseList(node1);
    }
}
