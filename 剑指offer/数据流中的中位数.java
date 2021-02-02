package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    

    class MedianFinder {

        PriorityQueue<Integer> left;//大顶
        PriorityQueue<Integer> right;//小顶

        /** initialize your data structure here. */
        public MedianFinder() {
            left=new PriorityQueue<>((n1,n2)->n2-n1);
            right=new PriorityQueue<>();
        }
        
        public void addNum(int num) {
          left.add(num);
          right.add(left.poll());
          if(left.size() +1 < right.size()) left.add(right.poll());
        }
        
        public double findMedian() {
           if(right.size() == left.size()) return (double)(right.peek() + left.peek())/2;
           else return right.peek();
        }
    }
}