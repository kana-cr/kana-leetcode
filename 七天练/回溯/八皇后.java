package 七天练.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 八皇后 {



    List<List<String>> list = new ArrayList<>();

    LinkedList<String> answer = new LinkedList<>();
  
    int[] result;//全局或成员变量,下标表示行,值表示queen存储在哪一列
  
    public List<List<String>> solveNQueens(int n) {
        result = new int[n];
        Arrays.fill(result, Integer.MIN_VALUE);
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < n; i++) s.append('.');
        addQueen(0 ,n, s);
        return list;
  
    }
  
    //判断row行column列放置是否合适
    private boolean checkIsOk(int[] result ,int row , int column ,int n){
        for(int i = 0; i < n; i++) if(column == result[i] || Math.abs(column-result[i]) == Math.abs(n-i)) return true;
        return false;
    }
  
  
    public void addQueen(int row ,int n, StringBuilder s){
        if(row == n){
            list.add(new ArrayList<>(answer));   
            return;
        } 
        //每行n种放法
        for (int column = 0; column < n ; column++) {
            if(checkIsOk(result, row, column ,n)){
                result[row] = column; // 第row行的棋子放到了column列
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(column,'Q');
                answer.add(sb.toString());
                addQueen(row + 1, n, s);
                answer.removeLast();
                result[row] = Integer.MIN_VALUE;
            }
        }
        
  
    }

    public void cal8queen(int row){
        if(row == 8){
            printQueens(result);
            return;
        } 
        //每行八种放法
        for (int column = 0; column < 8; column++) {
            if(checkIsOk(result, row, column,8)){
                result[row] = column; // 第row行的棋子放到了column列
                cal8queen(row + 1);
            }
            
        }

    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
          for (int column = 0; column < 8; ++column) {
            if (result[row] == column) System.out.print("Q ");
            else System.out.print("* ");
          }
          System.out.println();
        }
        System.out.println();
      }
}