import java.util.HashMap;

public class MyLRUMap {


    class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
}
      
    class LRUCache {
        private HashMap<Integer, DLinkedNode> cache =new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        private void removeNode(DLinkedNode node){
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void addNode(DLinkedNode node){
        node.next = head.next;    
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        }

        private void removeToHead(DLinkedNode node){
            //移除节点
            removeNode(node);
            //新加到head后面
            addNode(node);
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            return -1;
        }else{
        removeToHead(node);
        return node.value;
       }
       
        }
        
        public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addNode(node);
            size++;
        if(size > capacity){
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            
            size--;
        }
        }else{
            //直接更新引用
            node.value = value;
            //LUR Refresh
            removeToHead(node);
        }
    }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}