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


class TicTacToe {

    private int[][] grid;
    private int len;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.len = n;
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
        if(row<0 || col<0 || row>=len || col>=len)
            return -1;
        grid[row][col] = player==1?1:-1;
        if(horizontalWin(row))
            return player;
        else if(verticalWin(col))
            return player;
        else if(diagonalWin())
            return player;
        else
            return 0;
    }
    
    public boolean horizontalWin(int row){
        int sum = 0;
        for(int i=0;i<len;i++){
            if(grid[row][i]==0)
                break;
            sum+=grid[row][i];
        }
        return Math.abs(sum)==len?true:false;
    }
    
    public boolean verticalWin(int col){
        int sum = 0;
        for(int i=0;i<len;i++){
            if(grid[i][col]==0)
                break;
            sum+=grid[i][col];
        }
        return Math.abs(sum)==len?true:false;
    }
    
    public boolean diagonalWin(){
        boolean diagonal = true;
        boolean antiDiagonal = true;
        int diagonalSum = 0;
        int antiDiagonalSum = 0;
        for(int i=0;i<len;i++){
            if(grid[i][i]==0){
                diagonal = false;
                break;
            }
            diagonalSum+=grid[i][i];
        }
        for(int i=0;i<len;i++){
            if(grid[i][len-1-i] == 0){
                antiDiagonal = false;
                break;
            }
            antiDiagonalSum += grid[i][len-1-i];
        }
        diagonal = Math.abs(diagonalSum)==len?true:false;
        antiDiagonal = Math.abs(antiDiagonalSum)==len?true:false;
        return diagonal||antiDiagonal;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


class TicTacToe {

    private int[][] grid;
    private int len;
    private int[] rowSum;
    private int[] colSum;
    private int[] diagonalSum;
    private int[] antiDiagonalSum;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.rowSum = new int[n];
        this.colSum = new int[n];
        this.diagonalSum = new int[n];
        this.antiDiagonalSum = new int[n];
        this.len = n;
        
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
        if(row<0 || col<0 || row>=len || col>=len)
            return -1;
        grid[row][col] = player==1?1:-1;
        if(horizontalWin(row, col))
            return player;
        else if(verticalWin(row, col))
            return player;
        else if(diagonalWin())
            return player;
        else
            return 0;
    }
    
    public boolean horizontalWin(int row, int col){
        int sum = 0;
        rowSum[row] += grid[row][col];
        return Math.abs(rowSum[row])==len?true:false;
    }
    
    public boolean verticalWin(int row, int col){
        int sum = 0;
        colSum[col] += grid[row][col];
        return Math.abs(colSum[col])==len?true:false;
    }
    
    public boolean diagonalWin(){
        boolean diagonal = true;
        boolean antiDiagonal = true;
        int diagonalSum = 0;
        int antiDiagonalSum = 0;
        for(int i=0;i<len;i++){
            if(grid[i][i]==0){
                diagonal = false;
                break;
            }
            diagonalSum+=grid[i][i];
        }
        for(int i=0;i<len;i++){
            if(grid[i][len-1-i] == 0){
                antiDiagonal = false;
                break;
            }
            antiDiagonalSum += grid[i][len-1-i];
        }
        diagonal = Math.abs(diagonalSum)==len?true:false;
        antiDiagonal = Math.abs(antiDiagonalSum)==len?true:false;
        return diagonal||antiDiagonal;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */