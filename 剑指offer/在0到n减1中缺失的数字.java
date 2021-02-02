package 剑指offer;

public class 在0到n减1中缺失的数字{

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] != 0 ) return 0;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == mid) left = mid + 1;
            else right = mid;
        }
        //如果left是最后一个数，并且数组没有缺失数字
        return nums[left] == nums[nums.length - 1]&& nums[left] == left ?++left:left;
    }
    
 
}