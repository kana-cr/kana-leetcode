package 剑指offer;

public class 数组中数字出现的次数II {

    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int k = 0;
            while(nums[i] != 0){
                arr[k++] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        int res = 0;
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            res += j * (arr[i] % 3);
            j *= 2;
        }
       return res; 
    }
}