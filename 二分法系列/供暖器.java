package 二分法系列;

import java.util.Arrays;

//冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
// 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
// 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
public class 供暖器 {

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int res = 0;
        int len = heaters.length;
        for (int house:houses) {
        int left = 0;
        int right = len;
        while (left < right){
            int mid = left + (right - left) / 2;
            //找到离房子最近的供暖器
            if (house > heaters[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
            //最左的供暖器离当前房子最近
            int dist1 = right == 0 ? Integer.MAX_VALUE : Math.abs(house - heaters[right - 1]);
            //最右的供暖器离当前房子最近
            int dist2 = right == len ? Integer.MAX_VALUE : Math.abs(house - heaters[right]);
            //取出更大的那个，来满足每个房子能被供暖的最短路径 Math.min(dist1,dist2)代表当前房子需要的最短路径
            res = Math.max(res,Math.min(dist1,dist2));

        }
        return res;
    }

    public static void main(String[] args) {
        findRadius(new int[]{1},new int[]{1,2,3,4});
    }
}
