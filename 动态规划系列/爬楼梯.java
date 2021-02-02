package 动态规划系列;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
public class 爬楼梯 {

    //递归过于耗时
    public int climbStairs(int n) {
        if (n == 1)
            return climbStairs(n - 1);
        if (n == 0)
            return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs_Iteration(int n) {
        if(n<=2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    //状态转移方程
    //opt ：指代特殊的计算逻辑，通常为 max or min。
    //i,j,k 都是在定义DP方程中用到的参数。
    //dp[i] = opt(dp[i-1])+1
    //dp[i][j] = w(i,j,k) + opt(dp[i-1][k])
    //dp[i][j] = opt(dp[i-1][j] + xi, dp[i][j-1] + yj, ...)
    public int climbStairs_dp(int n) {
        if (n==1)
            return 1;
        int[] dp =new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
