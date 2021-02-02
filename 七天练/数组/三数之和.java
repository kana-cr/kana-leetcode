package 七天练.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 三数之和 {

    
    public List<List<Integer>> threeSum_vol(int[] nums) {

    //List<List<Integer>> lists = new ArrayList<>();
    Set set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                int twoSum = nums[i] + nums[j];
                if(twoSum + nums[k] == 0){
                    List<Integer> result = Arrays.asList(nums[i],nums[j],nums[k]);
                    Collections.sort(result);
                    set.add(result);
                }else{
                    continue;
                }
            }
        }
    } 
    return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//先排序
       for(int first = 0;first < nums.length;first++){

           if(first > 0 && nums[first] == nums[first - 1])
           continue;//保证每次枚举不重复

           if(nums[first] > 0)
            return result;

           int third = nums.length - 1;//右指针
           int target = -nums[first];//目标值

           for (int second = first + 1; second < nums.length; second++) {

               if(second > first + 1&& nums[second] == nums[second - 1])
               continue;//保证不重复，同上

               while(second < third && nums[second] + nums[third] > target){
               third--;
               }
               if(second >= third)
               break;
               if(nums[second] + nums[third] == target){
                   result.add(Arrays.asList(nums[first],nums[second],nums[third]));
               }
           }

       }
       return result;
        
    }
}