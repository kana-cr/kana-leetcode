package 七天练.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 缺失的第一个正数 {
    
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Boolean> numMap = new HashMap<>();
        for (int i : nums) {
            if(i <= 0)
            continue;
            numMap.put(i, true);
        }
        for (int i = 1; i <= 300; i++) {
            if(numMap.get(i) == null)
            return i;
        }
        return 301;
        }

        //打标记法
        public int firstMissingPositive_tag(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= 0)
                nums[i] = nums.length + 1;
            }
            for (int i = 0; i < nums.length; i++) {
               if(nums[i] < nums.length + 1){
                   nums[Math.abs(nums[i])] = -Math.abs(nums[nums[i]]);
               }
            }
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0)
                return i + 1;
            }
            return nums.length + 1;
            }
    
}