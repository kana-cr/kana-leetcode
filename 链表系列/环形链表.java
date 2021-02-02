package 链表系列;

//给定一个链表，判断链表中是否有环。
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
public class 环形链表 {

    //快慢指针
    public ListNode detectCycle(ListNode head) {
        boolean hasCycle=false;
    if (head==null||head.next==null)
        return null;
    ListNode point_quick=head;
    ListNode point_slow=head;
    while (point_quick.next!=null&&point_quick.next.next!=null){
        point_quick=point_quick.next.next;
        point_slow=point_slow.next;
        if (point_quick==point_slow){
         hasCycle=true;
         //存在环
            break;
        }
    }
    //设 a为到入环点的长度，b为慢指针走到和快指针相遇点经过的长度 慢指针走了a+b
    //因为快指针走过的路径是慢指针两倍，故走了2(a+b)
        //又因为快指针走过的路径长度可以用a+b+(b+c)表示 注：快指针走完一圈(b+c), 又在环内多走了b的长度, 才和慢指针相遇
        //可以列等式得出，新指针和慢指针同步走会在环入口相遇
    if (hasCycle){
        ListNode q = head;
        while (q!=point_slow){
            q = q.next;
            point_slow=point_slow.next;
        }
        return q;
    }else {
        return null;
    }

    }
}
