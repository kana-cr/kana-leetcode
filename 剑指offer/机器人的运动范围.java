package 剑指offer;

public class 机器人的运动范围 {
    
    public int movingCount_dp(int m, int n, int k) {
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < dp.length && addSum(i+"") <= k; i++) {
                dp[i][0] = 1;
                res++;
        }
        for (int i = 1; i < dp[0].length && addSum(i+"") <= k; i++) {
                dp[0][i] = 1;
                res++;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if( ( dp[i - 1][j] == 1 || dp[i][j - 1] == 1 ) && (addSum(i+"") + addSum(j+"") <= k)){
                    dp[i][j] = 1;
                    res++;
                }
            }
        }
        return res;
    }

    private int addSum(String s){
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            res += Integer.valueOf(s.substring(i - 1, i));
        }
        return res;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, 0, 0, k);
    }

    private int dfs(boolean[][] visited ,int m ,int n ,int x ,int y,int k){
        if( x >= m || y >= n|| visited[x][y] || (x%10 + x/10 + y%10 + y/10) > k) 
        return 0;
        visited[x][y] = true;
        return dfs(visited, m, n, x + 1, y, k) + dfs(visited, m, n, x, y + 1, k) + 1;
        
    }  
}