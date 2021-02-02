package 剑指offer;

public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        ListNode head;
        if(l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        }else{
            head = l1;
            l1 = l1.next;
        }
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
             }else{
                cur.next = l1;
                l1=l1.next;
             }
             cur = cur.next;
        }
        if(l1 == null && l2 == null){
            return head;
        }else if(l1 == null){
         while(l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
         }
        }else if(l2 == null){
            while(l1 != null){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
             }
        }
        return head;
    }
}