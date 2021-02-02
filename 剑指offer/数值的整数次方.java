package 剑指offer;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
     return n > 0? pow(1,n,x): pow(1,n,1/x);
    }

    private double pow(double x ,int n ,double base){
      if(n == 0) return x;
      else if(n > 0){
         return  pow(x * base, n - 1, base);
       }else {
         return  pow(x * base, n + 1, base);
       }
    }

    public double myPow_qucik(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


}