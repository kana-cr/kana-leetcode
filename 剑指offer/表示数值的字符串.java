package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 表示数值的字符串 {
    
  
        @SuppressWarnings("all")
        public boolean isNumber_automatic(String s) {
            Map[] states = {
                new HashMap() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}                                         // 8.
            };
            int p = 0;
            char t;
            for(char c : s.toCharArray()) {
                if(c >= '0' && c <= '9') t = 'd';
                else if(c == '+' || c == '-') t = 's';
                else if(c == 'e' || c == 'E') t = 'e';
                else if(c == '.' || c == ' ') t = c;
                else t = '?';
                if(!states[p].containsKey(t)) return false;
                p = (int)states[p].get(t);
            }
            return p == 2 || p == 3 || p == 7 || p == 8;
        }




public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}