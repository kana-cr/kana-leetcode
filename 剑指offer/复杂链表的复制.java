package 剑指offer;

import java.util.HashMap;

public class 复杂链表的复制 {

    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node node = head;
        HashMap<Node,Node> nodeMap = new HashMap<>();
        while(node != null){
            nodeMap.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node != null){
            Node cur = nodeMap.get(node);
            cur.next = nodeMap.get(node.next);
            cur.random = nodeMap.get(node.random);
            node = node.next;
        }
        return nodeMap.get(head);
    }
}