package 其他;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
// 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//说明：你不能倾斜容器，且 n 的值至少为 2。
public class 盛最多水的容器 {

    //双指针优解
    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        int res = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            res = Math.max(res, minHeight * (right - left));
            if (height[left] == minHeight) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int maxArea_bl(int[] height) {
        int left = 0;
        int right = 1;
        int area = (right - left) * Math.min(height[right] , height[left]);
        for (int i = 2; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                area = Math.max( Math.min(height[i] , height[j]) * (i - j) , area );
            }
        }
        return area;
    }
}
