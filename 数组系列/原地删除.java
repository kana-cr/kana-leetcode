package 数组系列;

import java.util.Arrays;

//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
public class 原地删除 {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //原地删除
    private static int removeElement(int[] nums,int val){
        int i=0;
        for (int j = 0; j <nums.length ; j++) {
            if (nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
    //双指针
    public int removeElement_double_point(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
//删除排序数组中的重复项 类似
    public int remove_repeat(int[] nums){
        if (nums.length == 0)
            return 0;
        int last=nums[0];
        int index=1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]!=last){
                last=nums[i];
                nums[index++]=nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,2,5,6,7,2,4};
        System.out.println(removeElement(arr,2));
    }
}
