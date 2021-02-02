package 七天练.动态规划;

public class 买卖股票的最佳时机 {
    
    public int maxProfit(int[] prices) {
        int[] maxProfit = new int[prices.length];
        maxProfit[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - min);
        }
            int max = 0;
        for (int i = 0; i < maxProfit.length; i++) {
            max = Math.max(maxProfit[i], max);
        }
        return max;
    }

}