package 字符串系列;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
public class 反转字符串 {

    private void reverse(char[] s){
        if (s.length<=1)
            return;
    int left=0;
    int right=s.length-1;
    while (left<right){
        swap(s,left,right);
        left++;
        right--;
    }

    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
