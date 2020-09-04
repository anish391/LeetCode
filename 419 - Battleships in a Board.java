// DFS Solution

class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    // Horizontal ship 
                    if((j+1<board[0].length && board[i][j+1]=='X') || (j-1>=0 && board[i][j-1]=='X')){
                        dfs(board, i, j, true);
                    }
                    // Vertical ship
                    else if((i+1<board.length && board[i+1][j]=='X') || (i-1>=0 && board[i-1][j]=='X')){
                        dfs(board, i, j, false);
                    }
                    // Count increasing whether its a vertical/horizontal or single cell ship.
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] board, int row, int col, boolean isHorizontal){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!='X')
            return;
        board[row][col] = 'V';
        if(isHorizontal){
            dfs(board, row, col+1, isHorizontal);
            dfs(board, row, col-1, isHorizontal);
        }
        else{
            dfs(board, row+1, col, isHorizontal);
            dfs(board, row-1, col, isHorizontal);
        }
    }
}

// One-pass, using only O(1) extra memory and without modifying the value of the board
// The solution here is to count the heads of the battleships.
// A head of a battleship is a cell which does not have a left/top neighbor
class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X' && (i==0 || board[i-1][j]!='X') && (j==0 || board[i][j-1]!='X'))
                    count++;
            }
        }
        return count;
    }
}