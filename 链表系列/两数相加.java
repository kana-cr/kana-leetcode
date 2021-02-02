package 链表系列;

//给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字
public class 两数相加 {

    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
/*    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode cur=new ListNode(0);
        ListNode head=new ListNode(0);
        head.next=l1;
        int tmp=0;
        while (l1!=null&&l2!=null){
            l1.val+=l2.val;
            if (tmp!=0){
                l1.val++;
                tmp=0;
            }
            if (l1.val>=10){
                l1.val-=10;
                tmp=1;
            }
            if (tmp==1&&(l1.next==null||l2.next==null)){
                if (l1.next==null&&l2.next==null){
                    l1.next=new ListNode(1);
                    l1=l1.next;
                    l2=l2.next;
                    break;
                }
                while (l1.next!=null) {
                    l1.next = new ListNode(1 + l1.next.val);
                    tmp=0;
                    if (l1.next.val>=10){
                        l1.next.val-=10;
                        tmp=1;
                    }
                    l1=l1.next;
                    if (l1.next==null&&tmp==1){
                        l1.next=new ListNode(1);
                        break;
                    }
                }
                    //l1.next = new ListNode(1 + l2.next.val);
            }
            cur=l1;
            l1=l1.next;
            l2=l2.next;

        }
        while (l2!=null){
            cur.next=new ListNode(l2.val);
            //l1=l2;
            if (tmp==1) {
                cur.next.val++;
                tmp=0;
            }
            if (cur.next.val>=10){
                cur.next.val-=10;
                tmp=1;
            }
            l2=l2.next;
            cur=cur.next;
            if (l2==null&&tmp==1)
                cur.next.next=new ListNode(1);
        }
            //cur.next=new ListNode(0);

        return head.next;
    }*/

    public static void main(String[] args) {
        ListNode node1=new ListNode(9);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(7);
        node2.next= node3;
        node3.next=new ListNode(8);
        addTwoNumbers(node1,new ListNode(9));
    }
}
