package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class 最长不含重复字符的子字符串 {
    
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || s.equals("")) return result;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int len = s.length();
        while(i < len && j < len){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                i++;
                result = Math.max(result, i - j);
            }else{
                set.remove(s.charAt(j));
                j++;

            }
        }
        return result;
    }
}