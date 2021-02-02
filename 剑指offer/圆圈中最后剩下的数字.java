package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public int lastRemaining_list(int n, int m) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while(n > 1){
             count=(count - 1 + m ) % n;
             list.remove(count);
             n--;
        }
        return list.get(0);

    }
}