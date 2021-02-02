package 字符串系列;

import java.util.HashMap;
import java.util.Map;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1 。
public class 字符串中的第一个唯一字符 {

    //O(n^2)
    public static int firstUniqChar(String s){
        Map<Character,Integer> charMap=new HashMap<>(26);
       char[] chars=s.toCharArray();
       /* for (char letter = 'a';letter <= 'z'; letter++) {
            charMap.put(letter,0);
        }*/
        for (char c: chars) {
           Integer count=charMap.get(c);
          count=count==null?1:count+1;
           charMap.put(c,count);
        }
        for (int i = 0; i <s.length() ; i++) {
            if (charMap.get(chars[i])==1)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
      firstUniqChar("aijvhasuihgfasuigahs");
    }
}
