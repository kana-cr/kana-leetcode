package 字符串系列;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
public class 验证回文串 {
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
    //不使用正则而选择直接跳过
    public boolean isPalindrome_noRegex(String s){
        char[] c=s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if (!((c[i] >= '0' && c[i] <= '9') || (c[i] >= 'a' && c[i] <= 'z'))) {
                i++;
                continue;
            }
            if (!((c[j] >= '0' && c[j] <= '9') || (c[j] >= 'a' && c[j] <= 'z'))) {
                j--;
                continue;
            }
            if(c[i] != c[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
