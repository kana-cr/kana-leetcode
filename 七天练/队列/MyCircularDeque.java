package 七天练.队列;

import java.util.LinkedList;

class MyCircularDeque {


    LinkedList<Integer> queue = new LinkedList<>();

    int size = 0;

    int count = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
     size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(!isFull()){
     queue.addFirst(value);
     count++;
     return true;
    }
     return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(!isFull()){
            queue.addLast(value);
            count++;
            return true;
           }
            return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
     if(!isEmpty()){
       queue.removeFirst();
       count--;
       return true;
    }
     return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(!isEmpty()){
            queue.removeLast();
            count--;
            return true;
         }
          return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
       if(!isEmpty()){
       return queue.getFirst();
    }
       return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(!isEmpty()){
            return queue.getLast();
         }
           return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
    return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
    return count == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */