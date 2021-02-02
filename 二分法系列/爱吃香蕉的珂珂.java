package 二分法系列;

import java.util.Arrays;

//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
//珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
public class 爱吃香蕉的珂珂 {

    //暴力超出时间限制
    public int minEatingSpeed_bf(int[] piles, int H) {
        int hours = 0;
        int i = 1;
        boolean canEat=false;
        while (!canEat) {
            int[] arr=Arrays.copyOf(piles,piles.length);
            tryEat:
            for (int j = 0; j < arr.length; j++) {
                while (arr[j] > 0) {
                    if (hours > H) {
                        hours = 0;
                        i++;
                        break tryEat;
                    }
                    arr[j] -= i;
                    hours++;
                }
            }
            if (hours<=H&&hours!=0)
            canEat=true;
        }
        return i;
    }
    //二分法优化
    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (canEat(piles, mid, H)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private boolean canEat(int[] piles, int speed, int H) {
        int sum = 0;
        for (int pile : piles) {
            //向上取整
            sum += Math.ceil(pile * 1.0 / speed);
        }
        return sum > H;
    }

}
