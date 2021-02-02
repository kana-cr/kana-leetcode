package 其他;

//初始时有 n 个灯泡关闭 。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次
// 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭
// 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关
// 找出 n 轮后有多少个亮着的灯泡。

public class 灯泡开关 {

    //超时
    public int bulbSwitch_outtime(int n) {
        if (n <= 1)
            return n;
        int count = 0;
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n ;i++) {
            int index = i;
            while ( index <= n ){
                contrast(arr,index);
                index += i;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i])
                count++;
        }
        return count;
    }

    public void contrast(boolean[] arr , int i){
        arr[i]= !arr[i];
    }

    //其实是求公因数有奇数个的数，也就是完全平方数的个数
    public int bulbSwitch(int n) {
        if (n <= 1)
            return n;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if ( Math.sqrt(i) - (int)Math.sqrt(i) ==0)
                count++;
        }
        return count;
    }
    //最简洁
    public int bulbSwitch_sqrt(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }
}
