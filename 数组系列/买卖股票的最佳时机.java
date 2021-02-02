package 数组系列;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
public class 买卖股票的最佳时机 {

    private int  maxProfit(int[] prices){
    if (prices.length < 2){
        return 0;
    }
    int[][] dp=new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
        dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i]);//不买 与 买了前一天的然后今天卖出 二者中的更划算者
        dp[i][1] = max(dp[i-1][0]-prices[i],dp[i-1][1]);//今天买入与昨天买入二者中花费更小者
        }
       return dp[prices.length-1][0];
    }

    private int max(int a,int b){
        return a>b? a : b;
    }
}
