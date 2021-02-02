package 数组系列;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
public class 两数之和 {

    //暴力解法 时间复杂度过高
    private static int[] twoSum(int[] nums,int target){
        for (int i = 0; i <nums.length - 1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[j]==target-nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    private static int[] twoSum_hash(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>(nums.length);
        for (int i = 0; i <nums.length ; i++) {
            if ( map.containsKey(target-nums[i])){
                int j = map.get(target-nums[i]);
                return new int[]{i,j};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
