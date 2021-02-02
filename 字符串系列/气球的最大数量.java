package 字符串系列;

public class 气球的最大数量 {

    //balloon
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[5];

        for (char s : text.toCharArray()) {
            if (s == 'b')
                arr[0] += 1;
            if (s == 'a')
                arr[1] += 1;
            if (s == 'l')
                arr[2] += 1;
            if (s == 'o')
                arr[3] += 1;
            if (s == 'n')
                arr[4] += 1;
        }
        arr[2]/=2;
        arr[3]/=2;
        int min = arr[0];
        for (int i:arr) {
            min = Math.min(min,i);
        }
        return min;
    }
}
