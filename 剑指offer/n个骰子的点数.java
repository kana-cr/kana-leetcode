package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n个骰子的点数 {

    HashMap<Integer,Double> res = new HashMap<>();

    public double[] dicesProbability_huisu(int n) {
        travel(n, 0, n);
        double[] ans = new double[res.size()];
        int i = 0;
        for (Map.Entry<Integer,Double> entry: res.entrySet()) {
            ans[i++] = entry.getValue();
        }
        Arrays.sort(ans);
        return ans;

    }

    private void travel(int n , int s ,int total){
        if(n == 0) {
            if(res.get(s) == null) res.put(s,Math.pow(0.16667, total) );
            else res.put(s, res.get(s) + Math.pow(0.16667, total));
            return ;
        }
        for (int i = 1; i < 7; i++) {
            travel(n - 1, s + i, total);
        }
    }

    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][6*n + 1];
        double[] ans = new double[5*n + 1];
        double all=Math.pow(6,n);
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        } 
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6*n; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] += j >= k?dp[i - 1][j - k]:0;
                    if(i == n) ans[j - i] = dp[i][j] / all;
                }
            }
        }
        return ans;
    }

}