class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int[][] oldState = new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            oldState[i] = Arrays.copyOf(board[i], board[i].length);
        }
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                int currentCell = oldState[row][col];
                int neighbors = 0;
                for(int[] dir: directions){
                    int r = row+dir[0];
                    int c = col+dir[1];
                    if(r<0 || c<0 || r>=board.length || c>=board[0].length)
                        continue;
                    neighbors += oldState[r][c]==1?1:0;
                }
                if(currentCell==1)
                    if(neighbors<2 || neighbors>3)
                        board[row][col] = 0;
                if(currentCell==0)
                    if(neighbors==3)
                        board[row][col] = 1;
            }
        }
    }
}

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                int neighbors = 0;
                int currentCell = board[row][col];
                for(int[] dir: directions){
                    int r = row+dir[0];
                    int c = col+dir[1];
                    if(r<0 || c<0 || r>=board.length || c>=board[0].length)
                        continue;
                    neighbors+= Math.abs(board[r][c])==1?1:0;
                }
                if(currentCell==1){
                    if(neighbors<2 || neighbors>3)
                        board[row][col] = -1;
                }
                else if(currentCell==0){
                    if(neighbors==3)
                        board[row][col] = 2;
                }
            }
        }
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]>0)
                    board[row][col] = 1;
                else 
                    board[row][col] = 0;
            }
        }
    }
}