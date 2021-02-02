package 剑指offer;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length , col = matrix[0].length;
        int i = 0,j = col - 1;
        if(matrix[0][0] > target || matrix[row - 1][j] < target) return false;
        while(i < row && j > 0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}