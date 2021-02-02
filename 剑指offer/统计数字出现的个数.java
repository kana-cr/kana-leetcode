package 剑指offer;

public class 统计数字出现的个数 {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int first = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + ( (right - left) >> 1);
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                if(mid == 0 || nums[mid - 1] != target) {first = mid; break;}
                else right = mid - 1;
            }
        }
        if(first == -1 && nums[left] == target) first = left;
        if(first == -1 || nums[first] != target) return 0;
        for (int i = first; i < nums.length; i++) {
            if(nums[i] != target) return i - first;
        }
        return nums[nums.length - 1] == target?nums.length - first:0;
    }
}