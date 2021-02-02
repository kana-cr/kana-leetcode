package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class 栈的压入和弹出序列 {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        if(pushed.length == 0 || popped.length == 0) return true;
        int len = pushed.length;
        stack.push(pushed[0]);
        int i = 1;
        int j = 0;
        while(!stack.isEmpty()){
        int cur = stack.peek();
        if(cur == popped[j]) {
            stack.pop(); 
            j++;
        }else {
            if(i >= len) return false; 
            stack.push(pushed[i++]);
             }
         if(i < len && stack.isEmpty()) stack.push(pushed[i++]);    
        }
         
        return true;
    }
}