class Solution {
    public int numRookCaptures(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='R'){
                    int up = captures(board, i, j, 1, 0);
                    int down = captures(board, i, j, -1, 0);
                    int left = captures(board, i, j, 0, -1);
                    int right = captures(board, i, j, 0, 1);
                    return up+down+left+right;
                }
            }
        }
        return 0;
    }
    
    public int captures(char[][] board, int x, int y, int dx, int dy){
        while(x>0 && x<board.length && y>0 && y<board.length && board[x][y]!='B'){
            if(board[x][y]=='p')
                return 1;
            x+=dx;
            y+=dy;
        }
        return 0;
    }
}