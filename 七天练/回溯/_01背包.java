package 七天练.回溯;

public class _01背包 {
    public int maxW = Integer.MAX_VALUE;
    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
// w背包重量；items表示每个物品的重量；n表示物品个数
// 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
// f(0, 0, a, 10, 100)

   public void f(int i, int cw, int[] items, int n, int w) {
       if(cw == w || i == n){
           // cw==w表示装满了;i==n表示已经考察完所有的物品
           if (cw > maxW) maxW = cw;
           return;
       }
       f(i + 1, cw, items, n, w);
       if(cw + items[i] <= w){
           f(i, cw + items[i], items, n + 1, w);
       } 


   }
}