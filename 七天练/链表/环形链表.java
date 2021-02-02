package 七天练.链表;

public class 环形链表 {

 class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
         val = x;
         next = null;
           }
     }

     public boolean hasCycle(ListNode head) {
         ListNode qucik = head;
         ListNode slow = head; 
        while(head.next != null && head.next.next!=null){
        qucik = qucik.next.next;
        slow = slow.next;
        if(qucik == slow)
        return true;
        }

        return false;
    }
}