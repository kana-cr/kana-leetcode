package 剑指offer;

public class 数字序列中某一位的数字 {

    public int findNthDigit(int n) {
        //分别是 n所在数字的位数 n数字范围开始的第一个数 占多少位
        int digtal = 1 ;
        long start = 1 , count = 9;
        while(n > count){
            n -= count;
            digtal++;
            start *= 10;
            count = digtal * start *9;
        }
        long num = start + (n - 1)/digtal;
        return String.valueOf(num).charAt((n - 1)% digtal) - '0';
    }
}