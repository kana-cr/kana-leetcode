package 七天练.链表;

public class 合并K个升序链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
          }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        return null;
        int index;
        index = chooseMinNode(lists);
        if(index == -1)
        return null;
        ListNode node = new ListNode(lists[index].val);
        lists[index] = lists[index].next;//将所有当中最小值的节点转移到新的节点
        ListNode head = node;
        while(true){
            index = chooseMinNode(lists);
            if(index == -1)
            break;
            node.next = new ListNode(lists[index].val);
            lists[index] = lists[index].next;
            node = node.next;
        }
       return head;

    }

    private int chooseMinNode(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int index = -1;
        //ListNode cur = null;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null)
            continue;
            if(lists[i].val <= min){
            min = lists[i].val;
            //cur = lists[i];
            index = i;
        }
    }
        return index;
        }
    }
