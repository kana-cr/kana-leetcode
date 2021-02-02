package 链表系列;


//链表题目大多可以引入哨兵节点
//哨兵节点，其实就是一个附加在原链表最前面用来简化边界条件的附加节点，它的值域不存储任何东西，只是为了操作方便而引入。
public class 删除链表倒数第N个节点 {

    //leetcode递归解法
    public ListNode removeNthFromEnd_Recursion(ListNode head, int n) {
        return removeNode(head,n)==n?head.next:head;
    }
    private int removeNode(ListNode node, int n) {
        if(node.next == null)  return 1;
        int m = removeNode(node.next, n);
        if(m == n)
            if(m == 1) node.next = null;
            else node.next = node.next.next;
        return m+1;
    }

    //使用计数 两趟遍历
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode first_node=head;
        ListNode second_node=head;
        if (head.next==null&&n==1){
            head=null;
            return head;
        }
        while (first_node.next != null){
            first_node=first_node.next;
            count++;
        }
        count-=n;
        if (count<0)
            return head=head.next;
        while (second_node!=null&&second_node.next!=null){
            if (count==0){
                second_node.next=second_node.next.next;
            }
            second_node=second_node.next;
            count--;
        }
        return head;
    }

    //双指针+哨兵
    private static ListNode removeNthFromEnd_doublePoint(ListNode head, int n){
     //定义哨兵
    ListNode sentinel=new ListNode(0);
    sentinel.next=head;
    ListNode node=sentinel;//指向头结点的指针用于移动,领先current结点n步
    ListNode current=sentinel;//需要删除的结点指针，当head遍历到尾部即是要删除的结点
    ListNode pre=sentinel;//用于操作删除current结点
         int i=1;//记录步数
    while (node.next != null){
        if (i>=n){
            pre=current;
            current=current.next;
        }
        node=node.next;
        i++;
    }
        assert pre.next != null;
        pre.next=pre.next.next;
    return sentinel.next;
    }

}
