import java.util.LinkedList;

public class MinStack {

       LinkedList<Integer> list;

       LinkedList<Integer> mins;

       int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {
            list = new LinkedList<>();
            mins = new LinkedList<>();
        }
        
        public void push(int x) {
        min = Math.min(min, x);
        mins.push(min);
        list.push(x);
        }
        
        public void pop() {
        list.pop();
        mins.pop();
        if(mins.isEmpty()) min = Integer.MAX_VALUE;
        else min = mins.peek();
        }
        
        public int top() {
        return list.peek();
        }
        
        public int min() {
        return mins.peek();
        }
    
}