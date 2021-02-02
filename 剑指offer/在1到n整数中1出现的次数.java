package 剑指offer;

public class 在1到n整数中1出现的次数 {
    
    public int countDigitOne(int n) {
        if(n < 10) return n == 0 ?0:1;
        String s = String.valueOf(n);
        int length = s.length();
        int base = (length - 1) * (int)Math.pow(10, length - 2);
        int high = s.charAt(0) - '0';
        int cur = (int)Math.pow(10, length - 1);
        if(high == 1){
            return base + 1 + n - cur + countDigitOne(n - cur);
        }else{
            return base*high + cur + countDigitOne(n - high*cur);
        }
    }
}