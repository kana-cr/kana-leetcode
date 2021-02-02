package 算法面试题汇总;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 分割回文串 {
    
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if(s == null || s.equals("")) return res;
        if(s.length() == 1) {res.add(new ArrayList<>(Arrays.asList(s))); return res;}
        List<String> list = new ArrayList<>();
        helper(s,list);
        return res;
    }

    public void helper(String s,List<String> list) {
        if(s == null || s.equals("")){res.add(list); return;}
        for (int i = 0; i < s.length(); i++) {
            //当前子串是回文串
            if(isPalindrome(s.substring(0,i + 1))){
            list.add(s.substring(0,i + 1));
            helper(s.substring(i + 1,s.length()), list);
            list.remove(list.size()-1);
        }
        }

    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] c=s.toCharArray();
        for (int i = 0; i <c.length ; i++) {
            if (i >= c.length-1-i)
                break;
            if (c[i]!=c[c.length-1-i])
                return false;
        }
        return true;
    }
}