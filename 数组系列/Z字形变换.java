package 数组系列;

import java.util.Arrays;

public class Z字形变换 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        char[] chars = s.toCharArray();
        int len = chars.length;
        int period = numRows * 2 - 2;
        for (int i = 0; i < len; i++) {
            int mod = i % period;
            if (mod < numRows) {
                arr[mod] += chars[i];
            } else {
                arr[period - mod] += String.valueOf(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }
        return res.toString();
    }

    public String convert_other(String s, int numRows) {
        if (numRows == 1) return s;
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            arr[i] += c;
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }
        return res.toString();
    }
}
