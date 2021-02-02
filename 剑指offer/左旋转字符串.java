package 剑指offer;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
    StringBuilder builder = new StringBuilder(s.substring(n));
    char[] sub = new char[n];
    for (int i = 0; i < n; i++) {
        sub[i] = s.charAt(i);
    }
    String subs = new String(sub);
    builder=builder.append(subs);
    return builder.toString();
    }
}