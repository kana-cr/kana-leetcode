package 二分法系列;

//假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本
public class 第一个错误的版本 {
    public int firstBadVersion(int n) {
    int left = 0;
    int right =n;
    while (left < right){
        //不能写成 int middle = (right + left)/2 + 1;
        // 因为可能有溢出风险
        int middle = left + (right - left)/2;
        if (isBadVersion(middle)){
            right=middle;
        }else {
            left=middle + 1;
        }
    }
    return left;
    }

    //假设是版本控制判断
    private boolean isBadVersion(int middle) {
        return false;
    }

}
