package 其他;

import java.util.HashMap;


public class LRU缓存机制 {


    class LRUCache {

        private HashMap<Integer, DLinkedNode> cache =
                new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next= node;
        }

        private void removeToHead(DLinkedNode node){
            removeNode(node);
            addNode(node);
        }
        private void removeNode(DLinkedNode node){
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public LRUCache(int capacity) {
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }


        public int get(int key) {
            DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }else {
            removeToHead(node);
        }
        return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null){
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key,newNode);
                addNode(newNode);
                size++;
            if (size > capacity){
               DLinkedNode tail = this.tail.prev;
               removeNode(tail);
               cache.remove(tail.key);
               size--;
            }
            } else {
                node.value = value;
                removeToHead(node);
            }
        }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    }



}
