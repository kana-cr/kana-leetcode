package 查找与排序经典算法;

import java.util.Arrays;

/**
  * @Author kana-cr
  * @Date  2020/8/13 14:55
  * @Param
  * @return
  * 最坏 O(lg n)
  **/
public class 归并排序 {

    private static int[] merge(int[] array1,int[] array2){
        int i=0,j=0;
        int size=array1.length+array2.length;
        int[] merge_array=new int[size];
        for (int s = 0; s < size ; s++) {
            if (i>=array1.length) {
                merge_array[s] = array2[j];
                j++;
                continue;
            }
            if (j>=array2.length) {
                merge_array[s] = array1[i];
                i++;
                continue;
            }
            if (array2[j]<array1[i]){
                merge_array[s]=array2[j];
                j++;
            }else {
                merge_array[s]=array1[i];
                i++;
            }
        }
        return merge_array;
    }
    public static void main(String[] args) {
        int[] array1={5,2,4,6,10,3};
        int[] array2={6,3,1,7,8,0};
        Arrays.sort(array1);
        Arrays.sort(array2);
        //升序
        System.out.println(Arrays.toString(merge(array1,array2)));
    }
}
