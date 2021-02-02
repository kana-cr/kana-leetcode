package 查找与排序经典算法;

import java.util.Arrays;

/**
  * @Author kana-cr
  * @Date  2020/8/13 14:56
  * @Param
  * @return
  * 最坏 O(n^2)
  **/
public class 插入排序 {

    private static int[] insert_sort_ASC(int[] array){
        int count=0;
        for (int i = 1; i <array.length ; i++) {
            int key=array[i];
            int j=i-1;
            while (j >= 0&&array[j] > key){
                array[j+1]=array[j];
                array[j]=key;
                j--;
                count++;
            }
        }
        System.out.println(count);
        return array;
    }
    private static int[] insert_sort_DESC(int[] array){
        for (int i = 1; i <array.length ; i++) {
            int key=array[i];
            int j=i-1;
            while (j >= 0&&array[j] < key){
                array[j+1]=array[j];
                array[j]=key;
                j--;
            }
        }
        return array;
    }


    public static void main(String[] args) {
    int[] array={5,2,4,0,18,21,6,1,3,7,11,};
        System.out.println(Arrays.toString(insert_sort_ASC(array)));
        System.out.println(Arrays.toString(insert_sort_DESC(array)));
    }
}
