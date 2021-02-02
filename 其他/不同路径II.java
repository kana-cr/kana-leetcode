package 其他;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 不同路径II {

    public static int uniquePathsWithObstacles_my(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (m == 1&&n == 0)
        return 1;
        if (obstacleGrid[m - 1][obstacleGrid[0].length - 1]==1 || obstacleGrid[0][0] == 1)
            return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = -1;
                while (i < m){
                    dp[i][0] = -1;
                    i++;
                }
            }else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = -1;
                while (i < m){
                    dp[0][i] = -1;
                    i++;
                }
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = -1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == -1)
                    continue;
                int up =  dp[i - 1][j] < 0? 0 :dp[i - 1][j];
                int left =  dp[i][j - 1] < 0 ? 0: dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        }
        for (int j = 1; j < n; j++  ) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        for (int i = 1; i < m; i++  ) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < m; i++  ) {
            for (int j = 1; j < n; j++ ) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j]  + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathsWithObstacles_best(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++ ) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j]  += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[1][1] = 1;
        System.out.println(Arrays.toString(arr));
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
