package 七天练.排序与二分;

public class 排序 {
    

//归并排序

//递推公式：merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
//终止条件：p >= r 不用再继续分解
// 非原地排序
// 稳定排序
public void merge_sort(int[] arr , int length){
   merge_sort_rel(arr, 0, length-1);
}

private void merge_sort_rel(int[] arr,int p , int r){
    //起点大于等于终点，返回
    if(p>=r) return ;
    //取p与r之间的中间位置
    int mid = (p + r) >> 1;
    //分而治之
  merge_sort_rel(arr, p, mid);
  merge_sort_rel(arr, mid+1, r);
    //合并
    merge(arr, p, mid,r);
}

private void merge(int[] arr,int left,int mid,int right){
     //初始化i,j,k
      int i=left,j=mid,k=0;    
      int[] tmp = new int[right-left];
      //归并
      while(i<=mid && j<=right){
         if(arr[i]<arr[j]){
             tmp[k++]=arr[i++];
         }else{
             tmp[k++]=arr[j++];
         }
      }
      //判断哪个子数组有剩余数据
      int start=i,end=mid;
      if(mid<=right){
          start=j;
          end=right;
      }
      //拷贝剩余数据
      while(start<=end){
           tmp[k++]=arr[start++];
      }

      //将tmp数组的数据拷贝回arr
      for (int l = 0; l < right-left; l++) {
          arr[l+left]=tmp[i];
      }
}


//快速排序

//递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
//终止条件：p >= r
// 原地排序
// 不稳定排序 

public void quick_sort(int[] arr ,int n){
       quick_sort_rel(arr, 0, n-1);
}

//快排递归函数
private void quick_sort_rel(int[] arr,int left,int right){
       if(left>=right)  return;

       //获取分区点
       int pivot = partition(arr, left, right);
       quick_sort_rel(arr, left, pivot);
       quick_sort_rel(arr, pivot+1, right);
}


//选择一个分区函数
private int partition(int[] arr,int left,int right){
      int pivot=arr[right];
      int i=left;
      for (int j = left; j < right; j++) {
          if(arr[j]<pivot){
              swap(arr, i, j);
              i++;
          }
      }
              swap(arr, i, right);  
     return i;        
}

//插入排序
//稳定 原地排序



//冒泡排序
//稳定 原地排序
public void bubble_sort(int[] arr , int n){
if(n<=1)   return;
for (int i = 0; i < n; i++) {
    boolean flag = false;
   for (int j = 0; j <n-i-1; j++) {
    if(arr[j]<arr[j+1]){
    swap(arr, j, j+1);
    flag = true;
   }
}
   //排序完成提前返回
   if(!flag){
       break;
}
}
}

//插入排序
//稳定 原地排序
public void insertion_sort(int[] arr,int n){
    if(n<=1)   return;
    for (int i = 1; i < n; i++) {
        int value = arr[i];
        int j = i-1;
          for (; j >= 0; j--) {
            if(value < arr[j]){
                //数据移动
               arr[j+1]=arr[j]; 
          }else{
              break;
          }
    }
    arr[j+1]=value;//插入数据
}
}

//选择排序
//稳定 原地排序
//每次选出未排序中最小的数插入前方排序数组的后方
public void choose_sort(int[] arr,int n){
    if(n<=1)   return;
    int index=0;
    for (int i = 0; i < n; i++) {
      int min = min(arr, index, n);
      swap(arr, min, index);
      index++;
    }
}

private int min(int[] arr,int left,int right){
    int min=arr[left];
    int index = 0;
    for (int i = left+1; i < right; i++) {
        if(arr[i]<min){
        min=arr[i];
        index=i;
    }
}
    return index;
}

//堆排序
//原地排序 稳定

//交换次数多，同时堆化不利于cpu缓存
public void buildHeap(int[] arr,int n){
    for (int i = n/2; i >= 1; i--) {
        heapify(arr, n, i);
    }
}

//大顶堆
private void heapify(int[] arr, int n, int i) {
    while(true){
        int maxPos = 1;
        //左子节点更大
        if(i*2 <= n && arr[i*2]>arr[i]) maxPos = i*2;
        //右子节点更大（考虑到左子节点是否大于右子节点的情况）
        if(i*2+1 <= n && arr[i*2+1]>arr[maxPos]) maxPos=i*2+1;
        //节点已经是当前子树最大
        if(maxPos == i) break;
        swap(arr, maxPos, i);
        i=maxPos;  
    }
}    

//堆排序
public void heap_sort(int[] arr,int n){
    //建堆
     buildHeap(arr, n);
     int k = n;
     while(k > 1){
         swap(arr, 1, k);
         k--;
         //调整大顶堆
         heapify(arr, 1, k);
     }
}



//交换
public void swap(int[] arr,int a,int b){
    int tmp = arr[a];
    arr[a]=arr[b];
    arr[b]=tmp;
}




}