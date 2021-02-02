package 二分法系列;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//请找出其中最小的元素。
//你可以假设数组中不存在重复元素。
public class 寻找旋转排序数组中的最小值 {

    //旋转排序数组 nums 可以被拆分为 2 个排序数组 nums1 , nums2 ，并且 nums1任一元素 >= nums2任一元素；
    // 因此，考虑二分法寻找此两数组的分界点 nums[i] (即第 2 个数组的首个元素)。
    //设置 left right 指针在 nums 数组两端，mid为每次二分的中点：
    //    当 nums[mid] > nums[right]时，mid 一定在第 1 个排序数组中，i 一定满足 mid < i <= right，因此执行 left = mid + 1；
    //    当 nums[mid] < nums[right] 时，mid 一定在第 2 个排序数组中，i 一定满足 left < i <= mid，因此执行 right = mid；

    //双指针(double Point)
    public int findMin_dp(int[] nums) {
     int left=0;
     int right=nums.length - 1;
     int oldLeft;
     int oldRight;
      while (left <= right){
          oldLeft=nums[left++];
          oldRight=nums[right--];
          if (left >= nums.length||right < 0)
              break;
          if (nums[left] < oldLeft)
              return nums[left];
          if (nums[right] > oldRight)
              return oldRight;

      }
      return nums[0];
    }

    //二分搜索

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[left] < nums[mid]) {
                left = mid ;
            } else if (nums[left] > nums[mid]) {
                right = mid - 1;
            }
        }
        return nums[(right + 1) % nums.length];
    }

    //数组中可能存在重复的元素的情况
    //二分

    public int findMin_repeat(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                //如果相等 削去一个右边界
                right--;
            }
        }
        return nums[left];
    }
}
