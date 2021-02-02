package 数组系列;

import java.util.Arrays;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
public class 旋转数组 {


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //非原地旋转
    private static int[] rotate_array(int[] arr,int k){
        if (arr==null)
            return null;
        if (k<=0)
            return arr;
        if (k>=arr.length)
            k %= arr.length;
        int[] new_arr=new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
         if (i + k > arr.length - 1){
             new_arr[i+k-arr.length]=arr[i];
         }else {
             new_arr[i+k]=arr[i];
         }
        }
        arr=null;
        return new_arr;
    }
    //原地旋转，先反转整个数组，再依次反转前k个和后length-k个即可
    private static int[] rotate_arr_reverse(int[] arr,int k){
        if (arr==null)
            return null;
        if (k<=0)
            return arr;
        if (k>=arr.length)
            k %= arr.length;
        //反转整个数组
        for (int i = 0; i <arr.length ; i++) {
            swap(arr,i,arr.length-1-i);
            if (i==arr.length-i-1|| i==arr.length-i-2)
                break;
        }
        //反转前k个
        for (int i = 0; i < k ; i++) {
            swap(arr,i,k-1-i);
            if (i==k-i-1|| i==k-i-2)
                break;
        }
        //反转后length-k个
        for (int i = k,j=0; i <arr.length ; i++,j++) {
            swap(arr,i,arr.length-1-j);
            if (i==arr.length-j-1|| i==arr.length-j-2)
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7};
        //System.out.println(  Arrays.toString( rotate_array(arr,3)));
        System.out.println(  Arrays.toString( rotate_arr_reverse(arr,3)));
    }
}
