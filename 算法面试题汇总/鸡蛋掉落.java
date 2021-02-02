package 算法面试题汇总;

public class 鸡蛋掉落 {
    
    //你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
    public int superEggDrop(int K, int N) {
    if(K == 1) return N;
    int[][] dp = new int[N + 1][K + 1];
    //当只有一个鸡蛋时要一层一层丢
    for (int i = 0; i <= N; i++) dp[i][1] = i;
    //每一层的状态
    for (int i = 1; i <= N; i++) {
    //从2个鸡蛋的情况开始
        for (int k = 2; k <= K; k++) {
            int res = Integer.MAX_VALUE;
           // for (int j = 1; j <= i; j++) {
          //      res = Math.min(Math.max(dp[j - 1][k - 1], dp[i - j][k]) + 1, res);
           // }
           int start = 1, end = i, mid;
           // 可能存在找不到的情况，因为两者的交点一定存在，但是横坐标不一定是一个整数，因此这里的res记录必不可少
           // 在没有整数交点的情况下，res会记录到交点两侧的的横坐标对应的较小值
           // 存在整数交点的情况下，res自然就记录到了整数交点处的最小值
           while (start <= end) {
               mid = start + (end - start) / 2;
               if (dp[mid-1][k-1] == dp [i-mid][k]) {
                   res = Math.min(res, dp[mid-1][k-1] + 1);
                   break;
               } else if (dp[mid-1][k-1] > dp[i-mid][k]) {
                   end = mid - 1;
                   res = Math.min(res, dp[mid-1][k-1] + 1);
               } else {
                   start = mid + 1;
                   res = Math.min(res, dp[i-mid][k] + 1);
               }
           }
            //确定当有K个鸡蛋时某层的状态
            dp[i][k] = res;
        }
    
    }
    return dp[N][K];
}
}