package 字符串系列;

//给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
//返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
public class 删除回文子序列 {

    public int removePalindromeSub(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int size = s.length();
        for (int i = 0; i < size / 2; i++) {
            if (s.charAt(i) != s.charAt(size -1 - i))
                return 2;
        }
        return 1;
    }

}
