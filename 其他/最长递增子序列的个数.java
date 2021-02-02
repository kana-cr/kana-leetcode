package 其他;


import java.util.Arrays;

//给定一个未排序的整数数组，找到最长递增子序列的个数。
public class 最长递增子序列的个数 {

    public static int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                if (lengths[i] >= lengths[j]) {
                    lengths[j] = lengths[i] + 1;
                    counts[j] = counts[i];
                } else if (lengths[i] + 1 == lengths[j]) {
                    counts[j] += counts[i];
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }



    //最长连续递增子序列
    //给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLength = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                length++;
            }
            if ( nums[i] <= nums[i - 1] || i == nums.length - 1){
                maxLength = Math.max(length ,maxLength);
                length = 1;

            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        findNumberOfLIS(new int[]{1,3,5,4,7});
        findNumberOfLIS(new int[]{2,2,2,2,2});
        findNumberOfLIS(new int[]{1,3,5,4,7,6,5,9,12,18,2,5,7,9});
    }
}
