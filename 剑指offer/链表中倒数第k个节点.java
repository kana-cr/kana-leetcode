package 剑指offer;

public class 链表中倒数第k个节点 {
    



  public ListNode getKthFromEnd(ListNode head, int k) {
  //快慢指针
  ListNode quick = head;
  ListNode slow = head;
  for (int i = 0; i < k; i++) {
      quick = quick.next;
  }
  if(quick == null)
  return head;
  
  while (quick.next != null) {
      slow = slow.next;
      quick = quick.next;
  }
  
  return slow.next;
 }
}