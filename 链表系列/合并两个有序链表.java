package 链表系列;


public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){
            return l1==null?l2:l1;
        }
    ListNode sentinel=new ListNode(0);//哨兵结点
    sentinel.next=l1.val<l2.val?l1:l2;
       if (l1.val<l2.val){
           l1=l1.next;
       }else {
           l2=l2.next;
       }
    ListNode head=sentinel.next;
    all:
    while (l1!=null||l2!=null){
        while (l1==null){
            head.next=l2;
            l2=l2.next;
            head=head.next;
            if (l2==null)
                break all;
        }
        while (l2==null){
            head.next=l1;
            l1=l1.next;
            head=head.next;
            if (l1==null)
                break all;
        }
        if (l1.val<l2.val){
            head.next=l1;
            l1=l1.next;
            head=head.next;
        }else {
            head.next=l2;
            l2=l2.next;
            head=head.next;
        }

    }
    return sentinel.next;
    }

    public ListNode mergeTwoLists_single(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}
