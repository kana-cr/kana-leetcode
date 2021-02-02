package 其他;

//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
public class 位1的个数 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (char c:s.toCharArray()) {
            if (c ==  '1')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        hammingWeight(00000000000000000000000000001011);
    }
}
