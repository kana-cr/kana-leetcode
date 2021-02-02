package 滑动窗口系列;

import java.util.ArrayList;
import java.util.List;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
public class 和为s的连续正数序列 {

    //先写 和为s的两个数字
    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
    //使用滑动窗口
    public int[] twoSum(int[] nums, int target) {
     int index=nums.length - 1;
        for (int i = 0; i < nums.length ; i++) {
           if ( nums[index] + nums[i] > target){
               index--;
               i--;
           }else if (nums[index] + nums[i] == target){
               return new int[]{nums[index],nums[i]};
           }
        }
        return new int[]{};
    }

    public  int[][] findContinuousSequence(int target) {
        int middle = target/2;
        List<int[]> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= middle + 1; i++) {
        list.add(i);
        while (addCount(list) > target){
            list.remove(0);
        }
        if (addCount(list)==target){
            int index=0;
            int[] arr=new int[list.size()];
            for (int dig:list) {
                arr[index++]=dig;
            }
         res.add(arr);
        }
        }
        return res.toArray(new int[res.size()][]);
    }
    private int addCount(List<Integer> list){
        int total = 0;
        for (int i:list) {
            total+=i;
        }
        return total;
    }

    public int[][] findContinuousSequence_other(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 1;
        int win = 0;
        while (i <= target / 2) {
            if (win < target) {
                win += j;
                j++;
            } else if (win > target) {
                win -= i;
                i++;
            } else {
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                win -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
