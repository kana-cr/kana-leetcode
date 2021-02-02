
public class MyLinkedList<E> {

    int size;

    Node<E> first;

    Node<E> last;

    //尾插法
    public Node<E> add(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
        return last;
    }

    //中间节点
    public Node<E> getMiddle(){
        Node<E> node = first;
        for (int i = 0; i < size/2; i++) {
            node = node.next;
        }
        return node;
    } 
    //反转链表
    public  Node<E> reverseList(Node<E> head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        Node<E> cur = head.next;
        Node<E> pre = head;
        head.next = null;
        while (cur.next != null){
            Node<E> node = cur.next;
            Node<E> tmp = cur;
            cur.next = pre;
            pre = tmp;
            cur = node;
        }
        cur.next = pre;
        return cur;
    }

   


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}