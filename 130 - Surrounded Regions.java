class Solution {
    public void solve(char[][] board) {
        if(board.length<=2 || board[0].length<=2)
            return;
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                solve(board, i, 0);
            if(board[i][board[0].length-1]=='O')
                solve(board, i, board[0].length-1);
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O')
                solve(board, 0, i);
            if(board[board.length-1][i]=='O')
                solve(board, board.length-1, i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='*')
                    board[i][j] = 'O';
                else if(board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
    }
    
    public void solve(char[][] board, int x, int y){
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!='O')
            return;
        board[x][y]='*';
        solve(board, x+1, y);
        solve(board, x-1, y);
        solve(board, x, y+1);
        solve(board, x, y-1);
    }
    
}