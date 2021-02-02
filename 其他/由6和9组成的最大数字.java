package 其他;
//给你一个仅由数字 6 和 9 组成的正整数 num。
//你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//请返回你可以得到的最大数字。
public class 由6和9组成的最大数字 {

    public int maximum69Number_api (int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6","9"));
    }

    public int maximum69Number (int num) {
        int thousand = num / 1000;
        if (thousand == 6)
            return 9000 + num % 1000;
        int hundred = (num % 1000) /100;
        if (hundred == 6)
            return thousand * 1000 + 900 + num % 100;
        int ten = (num % 100) /10;
        if (ten == 6)
            return thousand * 1000 + hundred * 100 + 90 + num % 10;
        if (num % 10 == 6)
            return thousand * 1000 + hundred * 100 + ten * 10 + 9;

        return num;
    }

}
