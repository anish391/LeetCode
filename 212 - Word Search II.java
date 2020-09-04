class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList();
        for(String word: words){
            if(exist(board, word))
                result.add(word);
        }
        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0))
                    if(dfs(board, word, i, j, 0))
                        return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int row, int col, int index){
        if(index==word.length())
            return true;
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=word.charAt(index))
            return false;
        board[row][col] = '*';
        boolean exists = dfs(board, word, row+1, col, index+1) ||
                            dfs(board, word, row-1, col, index+1) || 
                            dfs(board, word, row, col+1, index+1) ||
                            dfs(board, word, row, col-1, index+1);
        board[row][col] = word.charAt(index);
        return exists;
    }
}