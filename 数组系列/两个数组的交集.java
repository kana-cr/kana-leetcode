package 数组系列;

import java.util.Arrays;

//给定两个数组，编写一个函数来计算它们的交集。
public class 两个数组的交集 {


    private int[] intersect(int[] arr1,int[] arr2){
        if (arr1==null||arr2==null)
            return null;
        int size=arr1.length>arr2.length?arr1.length:arr2.length;
        int[] Intersection_array=new int[size];
        int[] usage=new int[size];
        int index=0;
        for (int value : arr1) {
            for (int j = 0; j < arr2.length; j++) {
                if (value == arr2[j] && usage[j] != 1) {
                    Intersection_array[index] = value;
                    index++;
                    usage[j] = 1;
                    break;
                }
            }
        }
        Intersection_array=Arrays.copyOf(Intersection_array,index);
        return Intersection_array;
    }
   // map映射关系求解
    private int[] intersect_map(int[] arr1,int[] arr2){
        if (arr1==null||arr2==null)
            return null;
        //int size=arr1.length>arr2.length?arr1.length:arr2.length;

        int[] map=new int[Integer.MAX_VALUE];
        for (int value : arr1) {
            map[value] = 1;
        }
        int index=0;
        for (int value: arr2) {
            if (map[value]>0){
                map[value]--;
                arr2[index]=map[value];
                index++;
            }
        }
       arr2=Arrays.copyOf(arr2,index);
        return arr2;
    }

 //进阶 如果是排好序的数组
 private int[] intersect_sort(int[] arr1,int[] arr2){
     if (arr1==null||arr2==null)
         return null;
     int i=0;
     int j=0;
     int k=0;
     Arrays.sort(arr1);
     Arrays.sort(arr2);
     for (;i<arr1.length&&j<arr2.length;){
         if (arr1[i]==arr2[j]){
             i++;
             j++;
             k++;
         }else if (arr1[i]>arr2[j]){
             j++;
         }else {
             i++;
         }
     }
     arr2=Arrays.copyOf(arr2,k);
     return arr2;
 }

}
