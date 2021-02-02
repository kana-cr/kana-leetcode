import java.util.Objects;

public class MyHashMap<K,V> {
    

    //存放Node的桶
    Node<K,V>[] table;

    //桶的个数
     int size = 0;

     //元素个数
     int count = 0;

    static class Node<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

public MyHashMap(Node<K, V>[] table) {
		this.table = table;
	} 


public V get(Object key){
    Node<K,V> head = table[hash(key)];
    while(head!=null){
        if(head.key.equals(key)) return head.value;
        head = head.next;
    }
    return null;
    }
    int hash(Object key) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (size -1); 
    }
  
public V put(K key,V value){
    //没有加上扩容
    Node<K,V> head = table[hash(key)];
    if(head == null)  table[hash(key)] = new Node<K,V>(hash(key),key,value,null);
    else  table[hash(key)] = new Node<K,V>(hash(key),key,value,head);
    return value;
}
    
}