class Solution {
    int result, empty, startRow, startCol;
    public int uniquePathsIII(int[][] grid) {
        result = 0; 
        empty = 1;
        int startRow=0, startCol=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    startRow = i;
                    startCol = j;
                }
                else if(grid[i][j]==0)
                    empty++;
            }
        }
        dfs(grid, startRow, startCol);
        return result;
    }
    
    public void dfs(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]<0)
            return;
        if(grid[row][col]==2){
            if(empty==0)
                result++;
            return;
        }
        empty--;
        grid[row][col]=-2;
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
        grid[row][col]=0;
        empty++;
    }
}