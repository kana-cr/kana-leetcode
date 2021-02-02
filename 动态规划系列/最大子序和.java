package 动态规划系列;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
public class 最大子序和 {

    public static int maxSubArray(int[] nums) {
        if (nums.length==0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            dp[i]=Math.max(dp[i-1] + nums[i] ,nums[i]);
            result = Math.max(result,dp[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1});
    }
}
