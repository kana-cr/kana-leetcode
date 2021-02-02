package 滑动窗口系列;

import java.util.*;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
// 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
public class 滑动窗口最大值 {

    //暴力求解
    public int[] maxSlidingWindow_violence(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i <= len - k; i++) {
            int max=nums[i];
            for (int j = i + 1; j < i + k  ; j++) {
            if (nums[j]>max)
                max=nums[j];
            }
            nums[i]=max;
        }
    return Arrays.copyOf(nums,len - k + 1);
    }

    //双端队列
    public int[] maxSlidingWindow_queue(int[] nums, int k) {
        int index=0;
        if (nums.length==0)
            return new int[]{};
        Deque<Integer> queue= new ArrayDeque<>();
        int[] result=new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (queue.size()>0&&nums[i]> queue.getLast()) {
                //将队列中比当前元素小的元素去除
                queue.removeLast();
            }
            //将当前元素放入queue中
           queue.addLast(nums[i]);
           if (i>=k && nums[i-k]==queue.getFirst()){
           queue.removeFirst();
           }
           if (i>=k-1){
               result[index]=queue.getFirst();
               index++;
           }
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // 保证从大到小 如果前面数小 弹出
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if(list.peek()<=i-k){
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if(i-k+1>=0){
                result[i-k+1] = nums[list.peek()];
            }
        }
        return result;
    }

}
