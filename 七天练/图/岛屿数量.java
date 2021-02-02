package 七天练.图;

import java.util.ArrayDeque;
import java.util.Deque;

public class 岛屿数量 {


    public int numIslands(char[][] grid) {
        int num_islands = 0;
        if(grid.length == 0 || grid[0].length == 0) return num_islands;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
               if(grid[i][j] == '1'){
                   num_islands++;
                   inject(i, j, grid);          
               }
            }
        } 
        return num_islands;
    }

    private void inject(int i,int j,char[][] grid){
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        if(i != grid.length - 1){
            inject(i+1, j, grid);
        }
        if(i != 0){
            inject(i-1, j, grid);
        }
        if(j != grid[i].length - 1){
            inject(i, j+1, grid);
        }
        if(j != 0){
            inject(i, j-1, grid);
        }
    }
}