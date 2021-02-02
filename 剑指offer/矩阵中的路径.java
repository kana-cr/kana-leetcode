package 剑指offer;

public class 矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                     if(dfs(visited, word, 0, board, i, j)) return true;
                }
            }
        }
        return false;

    }
    private boolean dfs(boolean[][] visited,String word,int index,char[][] board ,int i ,int j){
        if(index == word.length()) return true; 
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean res =  dfs(visited, word, index + 1, board, i - 1, j) || dfs(visited, word, index + 1, board, i + 1, j)
         ||  dfs(visited, word, index + 1, board, i, j - 1) || dfs(visited, word, index + 1, board, i, j + 1);
        visited[i][j] = false;
           return res;
        }
    }
