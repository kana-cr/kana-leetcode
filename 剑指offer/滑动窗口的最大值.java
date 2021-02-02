package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class 滑动窗口的最大值 {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums; 
        int[] sil = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i <= nums.length; i++) {
            while(queue.size() >0 && queue.getLast() < nums[i]){queue.removeLast();}
            queue.addLast(nums[i]);
            if(i >= k && queue.getFirst() == nums[i - k]){
                queue.removeFirst();
            }
            if(i >= k-1){
                sil[index++] = queue.getFirst();
            }
        }
        return sil;
        
    }
}