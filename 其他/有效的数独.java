package 其他;
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
public class 有效的数独 {

    //boxIndex = (row / 3) * 3 + columns / 3
    public boolean isValidSudoku(char[][] board) {
        int[][] col = new int[9][9];
        int[][] row = new int[9][9];
        int[][] sbox = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 ; j++) {
                if (board[i][j] != '.' ){
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if ( col[i][num] == 1)
                        return false;
                    col[i][num] = 1;
                    if ( row[j][num] == 1)
                        return false;
                    row[j][num] = 1;
                    if (sbox[boxIndex][num] == 1) return false;
                    sbox[boxIndex][num] = 1;
                }

            }
        }


        return true;
    }
}
