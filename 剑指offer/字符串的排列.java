package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 字符串的排列 {

    
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
       
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        travel(list,chars,new boolean[s.length()]);
        return res.toArray(new String[res.size()]);
    }
    
    private void travel(List<Character> list , char[] nums , boolean[] mark){
        if(list.size() == nums.length) {
            StringBuilder builder = new StringBuilder();
            for (char c : list) {
                builder.append(c);
            }
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
         if(mark[i]) continue;
         if(i > 0 && nums[i] == nums[i - 1] &&mark[i - 1]) continue;
            list.add(nums[i]);
            mark[i] = true;
            travel(list, nums,mark);
            list.remove(list.size() - 1);   
            mark[i] = false;
        }  
        }
}