package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        int colSize = matrix.length;
        int rowSize = matrix[0].length;
        if (colSize == 1) {
            List<Integer> list = new ArrayList<>((rowSize - 1)) ;
            for (int i = 0; i < rowSize; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }else if (rowSize == 1 ){
            List<Integer> list = new ArrayList<>((rowSize - 1)) ;
            for (int i = 0; i < rowSize; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

        List<Integer> list = new ArrayList<>( (colSize - 1) * (rowSize - 1) ) ;
        int right = rowSize - 1;
        int left = 0;
        int up = 0;
        int down = colSize - 1;
        while (right >= left || up >= down){
            for (int i = left; i <= right ; i++) {
                list.add(matrix[up][i]);
            }
            up++ ;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down ; i--) {
                list.add(matrix[down][i]);
            }
            down--;

            for (int i = down; i >= up && left <= right  ; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
