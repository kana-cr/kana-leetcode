package 其他;

import java.util.Arrays;
import java.util.PriorityQueue;

//在未排序的数组中找到第 k 个最大的元素。
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
public class 第k个最大元素 {

    public int findKthLargest_sort(int[] nums, int k) {
        Arrays.sort(nums);
       return nums[nums.length - 1 - (k-1) ];
    }
    public int findKthLargest_qp(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek()) {
                minQueue.offer(num);
            }
            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }
        return minQueue.peek();
    }
}
