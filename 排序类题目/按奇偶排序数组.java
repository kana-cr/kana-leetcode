package 排序类题目;

//给定一个非负整数数组 A，返回一个数组，在该数组中，
// A 的所有偶数元素之后跟着所有奇数元素。你可以返回满足此条件的任何数组作为答案。
public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0 ,j=i; i < A.length ; i++) {
           if (A[i]%2!=0){
            while (A.length-1-j>i){
                if (A[A.length-1-j]%2==0){
                    swap(A,i,A.length-1-j);
                    break;
                }else {
                    j++;
                }
            }
           }
        }
        return A;
    }
    private void swap(int[] arr,int a,int b){
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }

    //插排思想
    public int[] sortArrayByParity_insert(int[] A) {
        int index=0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==0){
                swap(A,i,index);
                index++;
            }
        }
        return A;
    }


}
