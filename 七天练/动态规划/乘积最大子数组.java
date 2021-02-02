package 七天练.动态规划;

public class 乘积最大子数组 {
    
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; 
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;}
            imax = Math.max(nums[i] * imax, nums[i]);
            imin = Math.min(nums[i] * imin, nums[i]);
            max = Math.max(imax, max);
        }

        return max;
    }
}