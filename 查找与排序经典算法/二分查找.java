package 查找与排序经典算法;
/**
  * @Author kana-cr
  * @Date  2020/8/13 14:57
  * @Param
  * @return
  * 最坏 O(lg n)
  **/
public class 二分查找 {
   //假设原数组升序
    //非递归实现
    private static void BinarySearch(int[] array,int target){
        if (array==null)
            return;
        int start = 0;
        int end = array.length-1;
        while (start <= end){
            int mid = start + (start+end) / 2;
            if (array[mid]==target) {
                System.out.println(mid);
                break;
             }
            if (array[mid]>target){
                end=mid-1;
                continue;
            }
           if (array[mid]<target){
                start=mid+1;
            }

        }
    }

    //递归实现
    public static int searchRecursion(int target,int[] array) {
        if (array != null) {
            return searchRecursion(target, 0, array.length - 1,array);
        }
        return -1;
    }
    private static int searchRecursion(int target, int start, int end,int[] array) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (target < array[mid]) {
            return searchRecursion(target, start, mid - 1,array);
        } else {
            return searchRecursion(target, mid + 1, end,array);
        }
    }

    public static void main(String[] args) {
        int[] array={5,2,4,0,18,21,6,1,3,7,11,};
        BinarySearch(array,21);
        BinarySearch(array,11);
        searchRecursion(21,array);

    }


}
