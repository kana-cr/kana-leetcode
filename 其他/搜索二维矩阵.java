package 其他;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值
//     每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。
public class 搜索二维矩阵 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 ){
            return false;
        }else if (matrix[0].length ==0)
            return false;
        int middle = (matrix.length - 1) / 2;
        int midStart = matrix[middle][0];
        int midEnd = matrix[middle][matrix[0].length - 1];
        while (middle != 0 && middle != matrix.length - 1){
            if (midStart == target || midEnd == target )
                return true;
            if (midStart < target && midEnd > target){
                int midVal =(matrix[middle].length - 1) / 2 ;
                while (midVal != 0 || midVal != matrix[middle].length - 1){
                    if (target == matrix[middle][midVal])
                        return true;
                    if (target <  matrix[middle][midVal] ){
                        midVal /= 2;
                    }else {
                        midVal = (midVal + (matrix[middle].length - 1) ) / 2;
                    }
                }
                return false;
            }

            if (midStart > target){
                middle /= 2;
            }else if (midEnd < target){
               middle =  ( middle + matrix.length) / 2;
            }
            midStart = matrix[middle][0];
            midEnd = matrix[middle][matrix[0].length - 1];

            if (middle == 0 || middle == matrix.length - 1){
                if (midStart == target || midEnd == target )
                    return true;
                if (matrix[middle][0] < target && matrix[middle][matrix.length - 1] > target){
                    int midVal =(matrix[middle].length - 1) / 2 ;
                    while (midVal != 0 || midVal != matrix[middle].length - 1){
                        if (target == matrix[middle][midVal])
                            return true;
                        if (target <  matrix[middle][midVal] ){
                            midVal /= 2;
                        }else {
                            midVal = (midVal + (matrix[middle].length - 1) ) / 2;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix_二分(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int row = getRow(matrix, target);
        return find(matrix[row], target);
    }

    public int getRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][col] < target)
                top = mid + 1;
            else
                bottom = mid;
        }
        return top;
    }

    public boolean find(int[] data, int target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (data[mid] == target)
                return true;
            else if (data[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        searchMatrix(arr,3);
    }

}
