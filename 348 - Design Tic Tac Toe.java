class TicTacToe {
    
    private int[][] grid;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.grid = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(row>=grid.length || col>=grid.length || row<0 || col<0)
            return 0;
        if(grid[row][col]!=0)
            return 0;
        grid[row][col] = player;
        if(verticalWin(col, player))
            return player;
        else if(horizontalWin(row, player))
            return player;
        else if(diagonalWin(player))
            return player;
        else
            return 0;
    }
    
    public boolean verticalWin(int col, int player){
        for(int i=0;i<grid[0].length;i++){
            if(grid[i][col]!=player)
                return false;
        }
        return true;
    }
    
    public boolean horizontalWin(int row, int player){
        for(int i=0;i<grid.length;i++){
            if(grid[row][i]!=player)
                return false;
        }
        return true;
    }
    
    public boolean diagonalWin(int player){
        boolean left = true;
        boolean right = true;
        for(int i=0;i<grid.length;i++){
            if(grid[i][i]!=player){
                left=false;
                break;
            }
        }
        for(int i=grid.length-1,j=0;i>=0&&j<grid.length;i--,j++){
            if(grid[i][j]!=player){
                right=false;
                break;
            }
        }
        return left||right;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */