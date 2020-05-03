class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        if(board[row][col]=='M'){
            board[row][col] = 'X';
        }
        else{
            int count = 0;
            for(int[] direction: directions){
                int r = row + direction[0];
                int c = col + direction[1];
                if(r<0 || c<0 || r>=m || c>=n)
                    continue;
                if(board[r][c]=='M' || board[r][c]=='X')
                    count++;
            }
            if(count>0)
                board[row][col] = (char)(count+'0');
            else{
                board[row][col] = 'B';
                for(int[] direction: directions){
                    int r = row+direction[0];
                    int c = col+direction[1];
                    if(r<0 || c<0 || r>=m || c>=n)
                        continue;
                    if(board[r][c]=='E')
                        updateBoard(board, new int[]{r,c});
                } 
            }
        }
        return board;
    }
}