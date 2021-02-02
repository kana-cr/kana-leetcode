package 动态规划系列;

//给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
public class 打家劫舍 {
    public int rob(int[] nums) {
     if (nums.length < 1)
         return 0;
     if (nums.length==1)
         return nums[0];
     if (nums.length==2)
         return Math.max(nums[0],nums[1]);
     nums[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i]=Math.max(nums[i - 1],nums[i - 2] + nums[i]);
        }
        return nums[nums.length - 1];
    }
}
