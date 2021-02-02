package 其他;

import java.util.Arrays;

//三枚石子放置在数轴上，位置分别为 a，b，c。每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，
// 并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。当你无法进行任何移动时，
// 即，这些石子的位置连续时，游戏结束。
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？
// 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
public class 移动石子直到连续 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        int[] answer = new int[2];
        int step = 0;
        if (arr[1] - arr[0] > 1)
            step ++;
        if (arr[2] - arr[1] > 1)
            step ++;
        if (arr[2] - arr[1] == 2 || arr[1] - arr[0] == 2)
            step = 1;
        answer[0] =  step;
        answer[1] = arr[2] - arr[0] - 2;
        return answer;
    }
}
