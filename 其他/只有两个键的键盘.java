package 其他;

import java.util.ArrayList;
import java.util.List;

//最初在一个记事本上只有一个字符 'A' 。
// 你每次可以对这个记事本进行两种操作：Copy All (复制全部) :
// 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。Paste (粘贴) : 你可以粘贴你上一次复制的字符
//给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
public class 只有两个键的键盘 {

    public int minSteps(int n) {
        //是质数返回n次
        if (n==1)
            return n - 1;
        else if (n==2 || isPrime(n))
            return n;
        //否则去找除自己以外的一个最大公因子
       int result = findCommonFactor(n);
        return minSteps(result) + (n / result) ;
    }

    private  boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private int findCommonFactor(int n){
        for (int i = n - 1; i>=2 ; i--) {
            if (n % i==0){
               return i;
            }
        }
        return 1;
    }
    public int minSteps_easy(int n) {
       int result = 0;
        for (int i = 2; i <= n ; i++) {
            while (n % i == 0) {
                n /= i;
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( new 只有两个键的键盘().minSteps_easy(100));
    }
}
