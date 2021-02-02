package 字符串系列;

import java.util.ArrayList;
import java.util.List;

public class 数组中的字符串匹配 {

    public List<String> stringMatching(String[] words) {
        List<String> arr = new ArrayList<>();
        for (String word:words) {

            for (String s:words) {
                if (word.length() >= s.length())
                    continue;
                if (s.contains(word)) {
                    arr.add(word);
                    break;
                }
            }

        }
        return arr;
    }
}
