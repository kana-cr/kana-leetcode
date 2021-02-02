package 查找与排序经典算法;

import java.util.Arrays;

/**
  * @Author kana-cr
  * @Date  2020/8/13 15:56
  * @Param
  * @return
  * 最坏时间复杂度在 O (nlg n)
  **/
public class 堆排序 {

    public int[] sort(int[] arr)  {

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }
    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }
    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        int len = arr.length;
        if (k == len)
            return arr;
        //对arr数组的前k个数建堆
        int[] heap = new int[k];
        System.arraycopy(arr,0,heap,0,k);
        buildMaxHeap(heap,k);
        //对后面较小的树建堆
        for (int i = k; i < len; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                heapify(heap, 0,heap.length);
            }
        }
        //返回这个堆
        return heap;
    }
    public static void main(String[] args) {
        堆排序 test = new 堆排序();

    }
}
