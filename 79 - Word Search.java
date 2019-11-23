class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board.length;j++)
                if(dfs(board,word,i,j,0))
                    return true;
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int x, int y, int index){
        if(index==word.length())
            return true;
        if(x<0 || y<0 || x>=board.length || y>= board[0].length || board[x][y]!=word.charAt(index))
            return false;
        board[x][y] = '*';
        boolean exist = dfs(board,word,x+1,y,index+1) || 
            dfs(board,word,x-1,y,index+1) ||
            dfs(board,word,x,y+1,index+1) ||
            dfs(board,word,x,y-1,index+1);
        board[x][y] = word.charAt(index);
        return exist;
    }
}