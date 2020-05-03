class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]!=1)
            return 0;
        grid[row][col] = 0;
        int up = dfs(grid, row-1, col);
        int down = dfs(grid, row+1, col);
        int left = dfs(grid, row, col-1);
        int right = dfs(grid, row, col+1);
        return up+down+left+right+1;
    }
}