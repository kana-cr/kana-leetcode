package 滑动窗口系列;

import java.util.HashSet;
import java.util.Set;

//给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //charAt：返回指定位置处的字符
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
