package 查找与排序经典算法;

import java.util.Arrays;

/**
  * @Author kana-cr
  * @Date  2020/8/14 14:38
  * @Param
  * @return
  * 考虑负数的情况还可以参考： https://code.i-harness.com/zh-CN/q/e98fa9
  **/
public class 基数排序 {

    private static void radixSort(int[] arr,int maxDigit){
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++,dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int [][] counter=new int[mod*2][0];
            for (int item : arr) {
                int bucket = ((item % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], item);
            }
            int pos=0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
    }


    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLengh(maxValue);
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private static int getNumLengh(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] array={5,2,4,0,18,21,6,1,3,7,11,};
        radixSort(array,getMaxDigit(array));
        System.out.println( Arrays.toString(array));
    }

}
