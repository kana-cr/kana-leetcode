import java.util.ArrayDeque;
import java.util.Deque;

//单调队列实现滑动窗口
public class MaxQueue {


    Deque<Integer> queue;

    Deque<Integer> record;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        record = new ArrayDeque<>();
    }
    
    public int max_value() {
        if(queue.isEmpty()) return -1;
        return record.peek();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while(!record.isEmpty() && record.peekLast() < value) record.pollLast();
        record.offer(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int val = queue.pop();
        if(record.peek() == val) record.pop();
        return val;
    }
}