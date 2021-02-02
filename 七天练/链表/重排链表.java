package 七天练.链表;

import java.util.ArrayList;
import java.util.List;

import 链表系列.ListNode;

public class 重排链表 {
    
    public static void reorderList(ListNode head) {
        if(head == null)
        return ;
         //要移动(length-1)/2个节点 前length - (length-1)/2个节点不变
         ListNode node = head;
         int length = 0;
         List<ListNode> nodes = new ArrayList<>();
         while(node!=null){
           nodes.add(node);
           node=node.next;
           length++;
         }
         node = head;
         for (int i = length - 1; i >= length - (length-1)/2 ; i--) {
           ListNode last = nodes.get(i);
           last.next = node.next;
           node.next = last;
           node = node.next.next;
         }
         if(length%2==0) node.next.next = null;
         else node.next = null;
     }
}