import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MyQueue {

    class CQueue {

        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }
        
        public void appendTail(int value) {
         stack1.add(value);
        }
        
        public int deleteHead() {
         if(!stack2.isEmpty()){
             return stack2.pop();
         }   else{
            if(stack1.isEmpty()) return -1;
             while(!stack1.isEmpty()) stack2.add(stack1.pop());
             return stack2.pop();   
        }
         }
        
    }
}