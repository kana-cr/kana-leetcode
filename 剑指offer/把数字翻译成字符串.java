package 剑指offer;

import java.util.HashMap;

public class 把数字翻译成字符串 {

    HashMap<String,Character> rMap = new HashMap<>();

    public int translateNum(int num) {
        for (int i = 0; i < 26; i++) {
            rMap.put(String.valueOf(i), (char) ('a' + i));
        }
       return replace(String.valueOf(num));
    }

    private int replace(String num){
        if(num == ""|| num.length() == 0) return 1;
        if(num.length() > 1 && rMap.get(num.substring(0, 2)) != null ){
            return replace(num.substring(2,num.length())) + replace(num.substring(1,num.length()));
        } else {
            return replace(num.substring(1,num.length()));
        }
    }
}