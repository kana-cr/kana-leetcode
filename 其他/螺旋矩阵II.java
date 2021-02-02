package 其他;

import java.util.ArrayList;
import java.util.List;

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {

      if (n==0)
          return new int[0][0];
      if (n==1) {
        int[][] arr = new int[1][1];
        arr[0][0] = 1;
          return arr;
      }
      int[][] matrix = new int[n][n];
        int dal = 1;
        int right = n - 1;
        int left = 0;
        int up = 0;
        int down = n - 1;
        while (dal > (n * n) ){
            for (int i = left; i <= right ; i++) {
                matrix[up][i] = dal++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = dal++;
            }
            right--;
            for (int i = right; i >= left && up <= down ; i--) {
                matrix[down][i] = dal++;
            }
            down--;

            for (int i = down; i >= up && left <= right  ; i--) {
                matrix[i][left] = dal++;
            }
            left++;
        }
        return matrix;
    }

    public int[][] generateMatrix_easy(int n) {
        int[][] res = new int[n][n];
        for (int s = 0, e = n - 1, m = 1; s <= e; s++, e--) {
            if (s == e) res[s][e] = m++;
            for (int j = s; j <= e - 1; j++) res[s][j] = m++;
            for (int i = s; i <= e - 1; i++) res[i][e] = m++;
            for (int j = e; j >= s + 1; j--) res[e][j] = m++;
            for (int i = e; i >= s + 1; i--) res[i][s] = m++;
        }
        return res;
    }
}
