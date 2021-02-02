package 剑指offer;

public class 顺时针打印矩阵 {
    

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    public int[] spiralOrder(int[][] matrix) {
        int[] arr = new int[matrix.length * matrix[0].length];
        //规定左右界与上下界
        int left = 0,right = matrix[0].length - 1;
        int up = 0 , down = matrix.length - 1;
        int i = 0;
         while(i < arr.length && left <= right && up <= down){
            for (int j = left; j <= right; j++) {
                arr[i++] = matrix[up][j];
            }
            up++;
            for (int j = up; j <= down; j++) {
                arr[i++] = matrix[j][right];
            }
            right--;
            for (int j = right; j >= left; j--) {
                arr[i++] = matrix[down][j];
            }
            down--;
            for (int j = down; j >= up; j--) {
                arr[i++] = matrix[j][left];
            }
             left++;
         }
         return arr;
    }
}