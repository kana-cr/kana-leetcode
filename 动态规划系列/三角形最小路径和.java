package 动态规划系列;

import java.util.List;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上
public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if(n==0) return 0;
        if(n==1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        dp[1][0]=triangle.get(1).get(0)+triangle.get(0).get(0);
        dp[1][1]=triangle.get(1).get(1)+triangle.get(0).get(0);
        //i行
        for(int i=2;i<n;i++)
        {
            //j列
            for(int j=0;j<=i;j++)
            {
                //j列第一个数字只能由正上方往下计算路径
                if(j==0) dp[i][j]=dp[i-1][j]+triangle.get(i).get(0);
                //j列最右边的只能由左上方往下计算路径
                else if(j==i) dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                //其他的可以比较最小求出到达当前点的最短路径
                else dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);

            }
        }
        int ans=dp[n-1][0];
        //最后一行每个点求最短路径
        for(int i=1;i<n;i++)
        {
            ans=Math.min(dp[n-1][i],ans);
        }
        return ans;
    }

}
