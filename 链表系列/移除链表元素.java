package 链表系列;

public class 移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.next == null)
            return head.val == val ? null:head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode cur = head;
        ListNode pre = first;
        while (cur != null){
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
                continue;
            }
            cur = cur.next;
            pre = pre.next;
        }

        return first.next;
    }

}
