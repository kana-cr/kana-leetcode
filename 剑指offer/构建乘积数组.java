package 剑指offer;

public class 构建乘积数组 {
    public int[] constructArr_vol(int[] a) {
    if(a.length <= 1) return a.length == 1?new int[]{1} : new int[]{};
    int[] res = new int[a.length];
    for (int i = 0; i < a.length; i++) {
        res[i] = mul(a, i);
    }
    return res;
    }
    private int mul(int[] a, int n){
        int sum = 1;
        for (int i = 0; i < a.length; i++) {
            if(i == n) continue;
            sum *= a[i];
        }
        return sum;
    }

    public int[] constructArr(int[] a) {
        if(a.length <= 1) return a.length == 1?new int[]{1} : new int[]{};
        int[] res = new int[a.length];
        for (int i = 0 , cur = 1; i < a.length; i++) {
           res[i] = cur;
           cur *= a[i];
        }
        for (int i = a.length - 1,cur = 1; i >= 0; i--) {
            res[i] *= cur;
            cur *= a[i];
        }
        return res;
        }
}