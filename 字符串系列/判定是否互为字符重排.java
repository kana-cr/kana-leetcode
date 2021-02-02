package 字符串系列;

import java.util.HashMap;
import java.util.Map;

//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串
public class 判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() ==0 || s2.length() == 0)
            return true;
        if(s1.length() != s2.length())
            return false;
        Map<Character,Integer> numMap = new HashMap<>();
        int count = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            if (numMap.get(s1.charAt(i)) == null) {
                numMap.put(s1.charAt(i), 1);
            }else {
                int num = numMap.get(s1.charAt(i));
                numMap.put(s1.charAt(i), num + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (count == 0)
                return true;
            Integer num = numMap.get(s2.charAt(i));
            if (num != null && num != 0) {
                numMap.put(s2.charAt(i), num - 1);
                count--;
            }
        }
        return count == 0;
    }
}

       /* if (s1.length() > s2.length()){
            int count = s2.length();
            Map<Character,Integer> numMap = new HashMap<>();
            for (int i = 0; i < s2.length(); i++) {
                if (numMap.get(s2.charAt(i))== null) {
                    numMap.put(s2.charAt(i), 1);
                }else {
                    int num = numMap.get(s2.charAt(i));
                    numMap.put(s2.charAt(i), num + 1);
                }
            }
            for (int i = 0; i < s1.length(); i++) {
                if (count ==0)
                    return true;
                Integer num = numMap.get(s1.charAt(i));
                if ( num != null && num != 0){
                    numMap.put(s1.charAt(i), num - 1);
                    count -- ;
                }
            }
            return count == 0;
        } else {
            int count = s1.length();
            Map<Character,Integer> numMap = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                if (numMap.get(s1.charAt(i)) == null) {
                    numMap.put(s1.charAt(i), 1);
                }else {
                    int num = numMap.get(s1.charAt(i));
                    numMap.put(s1.charAt(i), num + 1);
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (count ==0)
                    return true;
                Integer num = numMap.get(s2.charAt(i));
                if ( num != null && num != 0){
                    numMap.put(s2.charAt(i), num - 1);
                    count -- ;
                }
            }
            return count == 0;*/

