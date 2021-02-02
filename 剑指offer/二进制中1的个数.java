package 剑指offer;

public class 二进制中1的个数 {

     // you need to treat n as an unsigned value
     public int hammingWeight(int n) {
         int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n&1;
            n >>>= 1;
            //Integer.bitCount(i);
        }
        return res;
    }
}