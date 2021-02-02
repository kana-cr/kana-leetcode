package 其他;

public class 整数转罗马数字 {

    public static String intToRoman(int num) {
        int M = num / 1000;num %= 1000;
        int CM = num / 900;num %= 900;
        int D = num / 500;num %= 500;
        int CD = num / 400;num %= 400;
        int C = num / 100;num %= 100;
        int XC = num / 90;num %= 90;
        int L = num / 50;num %= 50;
        int XL = num / 40;num %= 40;
        int X = num / 10;num %= 10;
        int IX = num / 9;num %= 9;
        int V = num / 5;num %= 5;
        int IV = num / 4;num %= 4;
        int I = num;
        StringBuilder Roman = new StringBuilder();
        for (int i = 0; i < M; i++) {
            Roman.append("M");
        }
        for (int i = 0; i < CM; i++) {
            Roman.append("CM");
        }
        for (int i = 0; i < D; i++) {
            Roman.append("D");
        }
        for (int i = 0; i < CD; i++) {
            Roman.append("CD");
        }
        for (int i = 0; i < C; i++) {
            Roman.append("C");
        }
        for (int i = 0; i < XC; i++) {
            Roman.append("XC");
        }
        for (int i = 0; i < L; i++) {
            Roman.append("L");
        }
        for (int i = 0; i < XL; i++) {
            Roman.append("XL");
        }
        for (int i = 0; i < X; i++) {
            Roman.append("X");
        }
        for (int i = 0; i < IX; i++) {
            Roman.append("IX");
        }
        for (int i = 0; i < V; i++) {
            Roman.append("V");
        }
        for (int i = 0; i < IV; i++) {
            Roman.append("IV");
        }
        for (int i = 0; i < I; i++) {
            Roman.append("I");
        }
        return Roman.toString();
    }
    public String intToRoman_arr(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                result.append(romans[index]);
                num -= nums[index];
            } else {
                index ++;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        intToRoman(3);
    }
}
