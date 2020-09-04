class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null|| board.length==0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isValid(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board))
                                return true;
                            board[i][j]='.';    
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char num){
        int blockRow = (row/3)*3;
        int blockCol = (col/3)*3;
        for(int i=0;i<9;i++){
            if(board[i][col] == num || board[row][i] == num || board[blockRow + i/3][blockCol + i%3] == num)
                return false;
        }
        return true;
    }
}