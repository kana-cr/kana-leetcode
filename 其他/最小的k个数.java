package 其他;

import java.util.Arrays;

public class 最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] karr = new int[k];
        System.arraycopy(arr, 0, karr, 0, k);
        return karr;
    }


}
