package 滑动窗口系列;

import java.util.*;

//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引
//字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100
public class 字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
    if (s == null ||s.isEmpty()||s.length()<p.length())
        return list;
        int[] pArr = new int[26];
        int len=s.length();
        int[] sArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = p.length();
        // 窗口大小固定为p的长度
        while (j < len) {
            if (isSame(pArr, sArr))
                list.add(i);
            //左指针位置处字母减1
            sArr[s.charAt(i) - 'a']--;
            i++;
            //右指针位置处字母加1
            sArr[s.charAt(j) - 'a']++;
            j++;
        }
        if (isSame( pArr, sArr))
            list.add(i);
        return list;
    }

    private boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }


}
