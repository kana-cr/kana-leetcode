package 查找与排序经典算法;

import java.util.Arrays;

/**
  * @Author kana-cr
  * @Date  2020/8/14 13:58
  * @Param
  * @return
  * 最坏时间复杂度 O(n^2) 元素互异情况下期望时间复杂度是O(nlg n)
  **/
public class 快速排序 {

    private static void quickSort(int[] array,int start,int end){
        if (start < end){
        int partitionIndex = partition(array,start,end);
            quickSort(array,start,partitionIndex - 1);
            quickSort(array,partitionIndex + 1,end);
        }

    }
    private static int partition(int[] array,int start,int end){
     int pivot = start;
     //设置基准值
     int index = pivot + 1;
        for (int i = index; i <= end ; i++) {
         if (array[i]<array[pivot]) {
             //小于基准值的 放在左边
             swap(array, i, index);
             index ++;
         }
        }
        swap(array,pivot,index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array={5,2,4,0,18,21,6,1,3,7,11,};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
