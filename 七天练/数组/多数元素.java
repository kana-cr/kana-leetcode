package 七天练.数组;

import java.util.HashMap;
import java.util.Map;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
public class 多数元素{

    public int majorityElement(int[] nums) {
 
     Map<Integer,Integer> numMap = new HashMap<>();
     for (int i : nums) {
         if(!numMap.containsKey(i)){
         numMap.put(i,1);
         }else{
             numMap.replace(i, numMap.get(i) + 1);
         }
     }
     int majorityElement  = nums[0];
     int majorityValue = 0;
     for (Map.Entry<Integer,Integer> entry: numMap.entrySet()) {
        if(entry.getValue() > majorityValue){
            majorityElement = entry.getKey();
            majorityValue = entry.getValue();
        }
     }
     return majorityElement;
    }
    public int majorityElement_moer(int[] nums) {
    int candidate = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
        if(nums[i] == candidate){
            count++;
        }else{
            count--;
        }
        if(count == 0){
            candidate = nums[i];
            count = 1;
            }
    }
        return candidate;
    }
}