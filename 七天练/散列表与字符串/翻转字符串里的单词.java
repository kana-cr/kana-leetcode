package 七天练.散列表与字符串;

import java.util.Arrays;
import java.util.Collections;

public class 翻转字符串里的单词 {
    
    public String reverseWords(String s) {

        String[] ans = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = ans.length - 1; i >= 0; i--) {
            builder.append(ans[i].trim());
            builder.append(" ");
        }
        //builder.deleteCharAt(builder.length()-1);
    return builder.toString().trim();
    }
    

    public String reverseWords_api(String s) {

        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    
}