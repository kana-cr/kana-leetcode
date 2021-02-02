package 字符串系列;

//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
public class 最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int len=s.length();
        int count=0;
        int first_letter=0;
        for (int i = len -1; i >= 0 ; i--) {
            if (s.charAt(i)!=' '){
                first_letter=i;
                break;
            }
        }
        for (int i = first_letter; i >= 0 ; i--) {
             if (s.charAt(i)==' '){
             break;
             }else {
                 count++;
             }
        }
        return count;
    }

        public int lengthOfLastWord_split(String s) {
        String[] words = s.split(" ");
        if (words.length < 1) return 0;
        return words[words.length - 1].length();
    }

}
