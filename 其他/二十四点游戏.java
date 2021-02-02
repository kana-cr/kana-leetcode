package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通 *，/，+，-，(，) 的运算得到 24 。
public class 二十四点游戏 {
    class Solution {
        static final int TARGET = 24;
        static final double EPSILON = 1e-6;
        static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

        public boolean judgePoint24_leetcode(int[] nums) {
            List<Double> list = new ArrayList<>();
            for (int num : nums) {
                list.add((double) num);
            }
            return solve(list);
        }

        public boolean solve(List<Double> list) {
            if (list.size() == 0) {
                return false;
            }
            if (list.size() == 1) {
                return Math.abs(list.get(0) - TARGET) < EPSILON;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i != j) {
                        List<Double> list2 = new ArrayList<>();
                        for (int k = 0; k < size; k++) {
                            if (k != i && k != j) {
                                list2.add(list.get(k));
                            }
                        }
                        for (int k = 0; k < 4; k++) {
                            if (k < 2 && i > j) {
                                continue;
                            }
                            if (k == ADD) {
                                list2.add(list.get(i) + list.get(j));
                            } else if (k == MULTIPLY) {
                                list2.add(list.get(i) * list.get(j));
                            } else if (k == SUBTRACT) {
                                list2.add(list.get(i) - list.get(j));
                            } else if (k == DIVIDE) {
                                if (Math.abs(list.get(j)) < EPSILON) {
                                    continue;
                                } else {
                                    list2.add(list.get(i) / list.get(j));
                                }
                            }
                            if (solve(list2)) {
                                return true;
                            }
                            list2.remove(list2.size() - 1);
                        }
                    }
                }
            }
            return false;
        }
    }
    public boolean judgePoint24(int[] nums) {
        double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
        return help(a);
    }

    private boolean help(double[] a) {
        // 递归结束的条件，由于含有除号，
        // 因此，可以将数字转换成 double 类型的，
        // a[0] 表示最终计算的结果，如果最终计算的结果接近于 24，那么就返回 true
        if (a.length == 1) {
            return Math.abs(a[0] - 24) < 0.001;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                // 由于从数组中选择了两个数进行了计算，因此，数组 a 中还剩下 3 个数
                double[] b = new double[a.length - 1];
                // 以 [4, 1, 8, 7] 为例
                // 如果选择了 4 和 1，那么就把剩下的 8 和 7 放进数组 b 中
                // 此时，b 数组只剩下最后一位还没有赋值
                for (int k = 0, index = 0; k < a.length; k++) {
                    if (k != i && k != j) {
                        b[index++] = a[k];
                    }
                }
                for (double d : compute(a[i], a[j])) {
                    b[b.length - 1] = d;
                    if (help(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y) {
        return new double[]{x + y, x - y, y - x, x * y, x / y, y / x};
    }

}
