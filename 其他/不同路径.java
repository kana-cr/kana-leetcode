package 其他;

public class 不同路径 {

    public int uniquePaths_re(int m, int n) {
        if (m  == 1 || n  == 1)
            return 1;
        return uniquePaths_re(m - 1 ,n) + uniquePaths_re(m,n - 1);
    }

    public int uniquePaths(int m, int n) {
        if (m  == 1 || n  == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePaths_opt(int m, int n) {
        if (m  == 1 || n  == 1)
            return 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //注意，这里dp[j-1]已经是新一行的数据了，而dp[j]仍然是上一行的数据
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
