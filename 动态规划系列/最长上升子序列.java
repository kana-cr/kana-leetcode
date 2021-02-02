package 动态规划系列;

//给定一个无序的整数数组，找到其中最长上升子序列的长度
public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
    int[] dp = new int[nums.length];
    int result = 1;
        for (int i = 0; i < nums.length ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    //如果前面有小于自己的数字，那个数字子序列的长度和当前长度取更大者
                    dp[i] = Math.max(dp[j] + 1 ,dp[i]);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }

}
