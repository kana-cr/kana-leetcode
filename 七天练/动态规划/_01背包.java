package 七天练.动态规划;

public class _01背包 {
    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
private int[] weight = {2,2,4,6,3};  // 物品重量
private int n = 5; // 物品个数
private int w = 9; // 背包承受的最大重量
private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值false
public void f(int i, int cw) { // 调用f(0, 0)
  if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
    if (cw > maxW) maxW = cw;
    return;
  }
  if(mem[i][cw]) return;//跳过重复状态
  mem[i][cw] = true;//记住这个状态
  f(i+1, cw); // 选择不装第i个物品
  if (cw + weight[i] <= w) {
    f(i+1,cw + weight[i]); // 选择装第i个物品
  }
}


//weight:物品重量，n:物品个数，w:背包可承载重量
public int knapsack(int[] weight, int n, int w) {
    boolean[][] states = new boolean[n][w+1]; // 默认值false
    states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
    if (weight[0] <= w) {
        states[0][weight[0]] = true;
      }
      for (int i = 1; i < n; i++) {
          //不放入背包 要放在前面 不然可能会覆盖
          for (int j = 0; j <= w; j++) {
              //放入状态
              if(states[i - 1][j] == true) states[i][j] = states[i - 1][j];
          }
          //放入背包
          for (int j = 0; j < states.length; j++) {
            if(states[i - 1][j] == true) states[i][j + weight[i]] = states[i - 1][j] ;
          }
      }
      //输出结果
      for (int i = w; i >= 0; --i) { 
        if (states[n-1][i] == true) return i;
      }
      return 0;
}

//weight:物品重量，n:物品个数，w:背包可承载重量
public int knapsack2(int[] weight, int n, int w) {
    boolean[] states = new boolean[w+1]; // 默认值false
    states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
    if (weight[0] <= w) {
        states[weight[0]] = true;
      }
      for (int i = 1; i < n; i++) {
         
          //放入背包
          for (int j = w - weight[i]; j >= 0; j--) {
            if(states[j] == true) states[j + weight[i]] = true ;
          }
      }
      //输出结果
      for (int i = w; i >= 0; --i) { 
        if (states[i] == true) return i;
      }
      return 0;
}
public static int knapsack3(int[] weight, int[] value, int n, int w) {
    int[][] states = new int[n][w+1];
    for (int i = 0; i < n; ++i) { // 初始化states
      for (int j = 0; j < w+1; ++j) {
        states[i][j] = -1;
      }
    }
    states[0][0] = 0;
    if (weight[0] <= w) {
      states[0][weight[0]] = value[0];
    }
    int maxValue = -1;
    for (int i = 1; i < n; i++) {
        //不放入
       for (int j = 0; j <= w; j++) {
           if(states[i][j] >= 0) states[i][j] = states[i - 1][j];
       }
       for (int j = 0; j <= w - weight[j]; j++) {
           if(states[i - 1][j] >= 0){
               int v = states[i - 1][j] + value[i];
               if(v > states[i][j + weight[i]]) states[i][j + weight[i]] = v;
           }
           maxValue = Math.max(states[i][j], maxValue);
       }
    }
    return maxValue;
}
}