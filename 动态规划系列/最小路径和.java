package 动态规划系列;

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小
public class 最小路径和 {

    public int minPathSum(int[][] grid) {
    if (grid.length==0)
        return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j==0&&i!=0)
                    dp[i][j]=dp[i-1][j] + grid[i][j];
                else if (j!=0&&i==0)
                    dp[i][j]=dp[i][j-1] + grid[i][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j] ,dp[i][j-1] ) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
