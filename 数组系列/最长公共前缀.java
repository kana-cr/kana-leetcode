package 数组系列;

//编写一个函数来查找字符串数组中的最长公共前缀.如果不存在公共前缀，则返回""
public class 最长公共前缀 {

    private String longestCommonPrefix(String[] strings){
        if (strings==null||strings.length<1)
            return "";
        String prefix=strings[0];
        for (String k:strings) {
        while (!k.startsWith(prefix)){
            //每次都削短当前前缀  直到匹配为止
            prefix=prefix.substring(0,prefix.length()-1);
            if (prefix.length()==0){
                return "";
            }
        }
        }
        return prefix;
    }
}
