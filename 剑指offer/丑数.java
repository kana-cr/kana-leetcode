package 剑指offer;

public class 丑数 {
    
    public int nthUglyNumber(int n) {
        if(n <= 1) return n > 0 ? n : 0;
        int[] num = new int[n];
        int i = 0,j = 0,k = 0;
        num[0] = 1;
        for (int t = 1; t < num.length; t++) {
            int tmp = Math.min(num[i]*2, Math.min(num[j]*3, num[k]*5));
            if(num[i]*2 == tmp) i++;
            if(num[j]*3 == tmp) j++;
            if(num[k]*5 == tmp) k++;
            num[t] = tmp;
        }
        return num[n];
    }
}