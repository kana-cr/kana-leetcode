package 其他;
//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；
// 你需要返回可能的方案总数。
//返回答案 模 mod 10^9 + 7 之后的结果
public class 质数排列 {

    public int numPrimeArrangements(int n) {
        if (n == 1){
            return 1;
        }
        int i = 2;
        int primeCount = 0;
        while (i <= n){
           if (isPrime(i))
               primeCount++;
            i++;
        }
        return (int) (sum(primeCount)*sum(n - primeCount)%1000000007);
    }
    private  boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static long sum(int num){
        if (num == 1) {
            return 1;
        } else {
            return num * sum(num - 1) % 1000000007;
        }
    }
}
