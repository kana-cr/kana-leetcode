package 其他;

import java.util.HashMap;

//你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
// 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
// 你的朋友将会根据提示继续猜，直到猜出秘密数字。
public class 猜数字游戏 {

    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        StringBuilder cowbuffer = new StringBuilder(guess);
        HashMap<Character, Integer> digtalMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                cowbuffer.deleteCharAt(i - a);
                a++;
            }else {
                if (digtalMap.get(secret.charAt(i) ) == null){
                    digtalMap.put(secret.charAt(i) , 1);
                }else {
                    digtalMap.put(secret.charAt(i), digtalMap.get(secret.charAt(i)) + 1 );
                }
            }
        }
        for (int i = 0; i < cowbuffer.length(); i++) {
            Integer count = digtalMap.get(cowbuffer.charAt(i));
            if (count != null && count != 0){
                count --;
                b++;
                digtalMap.put(cowbuffer.charAt(i) , count);
            }
        }
        return a+"A"+b+"B";
    }
    public String getHint_leetcode(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0;
        int[] s = new int[10];
        int[] g = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            s[secret.charAt(i) - '0']++;
            g[guess.charAt(i) - '0']++;
            a += secret.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        for (int i = 0; i < s.length; i++)
            b += Math.min(s[i], g[i]);
        return sb.append(a).append("A").append(b - a).append("B").toString();
    }

    public static void main(String[] args) {
        猜数字游戏 test = new 猜数字游戏();
        test.getHint("1807","7810");
    }
}
