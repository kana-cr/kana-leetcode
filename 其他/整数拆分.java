package 其他;

import static java.lang.Math.max;

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积
public class 整数拆分 {

    public int integerBreak(int n) {
       if (n <= 2 )
           return 1;
       if (n == 3)
           return 2;
       int max = 0;
        for (int i = 0 ; i < n; i+=3 ) {
            int threeNumber = (int) Math.pow(3,i/3);
            max = max( threeNumber * (n-i) ,max);
        }
        return max;
    }
    public int integerBreak_o1(int n) {
        if (n <= 3) return n - 1;
        int x = n / 3, y = n % 3;
        //恰好整除，直接为3^x
        if (y == 0) return (int) Math.pow(3, x);
        //余数为1，退一步 3^(x-1)*2*2
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        //余数为2，直接乘以2
        return (int) Math.pow(3, x) * 2;
    }

    public int integerBreak_dp(int n) {
       int[] dp = new int[n + 1];
       dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for(int j = i - 1;j >= 1; j--) {
                dp[i]=max(dp[i],dp[j]*(i-j));
                dp[i]=max(dp[i],j*(i-j));
            }
        }
        return dp[n];
    }
}
