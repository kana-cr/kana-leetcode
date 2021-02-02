package 字符串系列;

import java.util.Arrays;

//给定两个字符串, A 和 B。A 的旋转操作就是将 A 最左边的字符移动到最右边。
// 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
public class 旋转字符串 {
    public boolean rotateString(String A, String B) {
        if (A.equals("") && B.equals("")) {
            return true;
        }
        int len = A.length();
        for (int i = 0; i < len ; i++) {
            String first=A.substring(0,1);
            String last=A.substring(1,len);
            A=last + first;
            if (A.equals(B))
                return true;
        }
        return false;
    }
    public boolean rotateString_child(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
    public boolean rotateString_KMP(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }
}
