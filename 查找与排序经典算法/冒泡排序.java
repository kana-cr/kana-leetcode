package 查找与排序经典算法;

import java.util.Arrays;

/**
  * @Author kana-cr
  * @Date  2020/8/13 14:58
  * @Param
  * @return
  * 最坏 O(n^2)
  **/
public class 冒泡排序 {

    //升序
    private static void BubbleSort(int[] array){
        int count=0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = array.length - 1; j > i ; j--) {
             if (array[j] < array[j-1]){
                 array[j]+=array[j-1];
                 array[j-1]=array[j]-array[j-1];
                 array[j]-=array[j-1];
                 count++;
             }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] array={5,2,4,0,18,21,6,1,3,7,11,};
        BubbleSort(array);
        System.out.println( Arrays.toString(array));
    }
}
