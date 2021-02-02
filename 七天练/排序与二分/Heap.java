package 七天练.排序与二分;

public class Heap {

    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数


    
  public Heap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void insert(int data) {
    if (count >= n) return; // 堆满了
    ++count;
    a[count] = data;
    int i = count;
    while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
      swap(a, i, i/2); // swap()函数作用：交换下标为i和i/2的两个元素
      i = i/2;
    }
  }
  
  public void removeMax(){
      if(count==0) return;
      a[1] = a[count];
      --count;
      heapify(a, count, 1);
  }

  private void heapify(int[] a, int n, int i) { // 自上往下堆化
    while (true) {
      int maxPos = i;
      if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
      if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
      if (maxPos == i) break;
      swap(a, i, maxPos);
      i = maxPos;
    }
}

  //交换
private void swap(int[] arr,int a,int b){
    int tmp = arr[a];
    arr[a]=arr[b];
    arr[b]=tmp;
}

public static void main(String[] args) {
    int[] arr = new int[]{5,6,1,2,4,8,11,47,51,0,-3};
    Heap heap = new Heap(arr.length);
    for (int i = 0; i < arr.length; i++) {
        heap.insert(arr[i]);
    }
    int k = 3;
    for (int i = 0; i < k; i++) {
        heap.removeMax();
    }
    System.out.println(heap.a[1]);
}
 }