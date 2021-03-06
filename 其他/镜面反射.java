package 其他;

//有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0，1，以及 2。
// 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
// 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
public class 镜面反射 {

    //找到公因子
    //光线每经过一次折反，都会在纵向距离上移动 q（首次与东墙相距的距离）。
    // 同时，一旦其向上行走的距离为 p 的整数倍，就一定会碰到某个接收点
    // （注意：这里我们不需要考虑北面墙是否存在，根据光的反射定律可得）
    //问题变得简单了，光线最终向上走的距离，其实就是 p 和 q 的最小公倍数。
    // 我们设最小公倍数为 L，会发现如果 L 是 p 的奇数倍，光线则到达北墙（可以参考上面的图）当 L 是 p 的 偶数倍，光线将会射到南墙。
    //如果光线是射向南墙，因为只有一个接收器了，必定只能遇到接收器 0。
    // 但是如果射到了北墙，如何区分是 1 和 2。这回到了一个初中数学题，我们可以通过光线与东西墙的接触次数，来判断最终的落点是 1 还是 2。
    public int mirrorReflection(int p, int q) {
        int m = p, n = q;
        int r;
        while (n > 0) {
            r = m % n;
            m = n;
            n = r;
        }
        if ((p / m) % 2 == 0) {
            return 2;
        } else if ((q / m) % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
