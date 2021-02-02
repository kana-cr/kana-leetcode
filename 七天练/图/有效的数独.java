package 七天练.图;

public class 有效的数独 {
    
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sbox = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               if (board[i][j] == '.') continue; 

               int num = board[i][j] - '1';

               if(row[i][num] != 0) return false; 
               else row[i][num] = 1;

               if(col[j][num] != 0) return false;
               else col[j][num] = 1;

               if(sbox[j/3 + i/3*3][num] != 0) return false;
               else sbox[j/3 + i/3*3][num] = 1;
            }
            
        }
        return true;
    }
}