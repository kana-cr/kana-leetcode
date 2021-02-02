package 剑指offer;

public class 不用加减乘除做加法 {
    
    //无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）。
    public int add(int a, int b) {
    //进位为0时跳出    
    while(b != 0){
    //c是进位
    int c = (a & b) << 1;
    //a是无进位和
    a = a ^ b;
    //b是进位
    b = c;
    }
    return a;
    }

    public int add_alu(int a,int b){
        int s = a ^ b,c = 0;
        for (int i = -1; i != 0; i >>= 1) {
            c >>= 1;
            c |= ( (a & b| a & c >> 30| b & c >> 30) & 1) << 31;
            a >>= 1;
            b >>= 1;
        }
        s ^= c<<1;
        return (int)s;  // 加法器s = a ^ b ^ c
    }

    public int add_ALU(int a, int b) {
        int ans = 0, mark = 0;
        int count = 0xffffffff;
        while ((count&1) == 1) {
            ans |= ((a & 1) ^ (b & 1) ^ mark) << 32 - Integer.bitCount(count);//与上当前位
            mark = (a & b & 1) | (a & 1 & mark) | (b & 1 & mark);//进位
            a >>=1;
            b >>=1;
            count >>>= 1;
        }
        return ans;
    }
}