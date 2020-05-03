class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid==null || grid.length==0 || grid[0].length==0)
            return perimeter;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    perimeter+= computePerimeter(i,j,grid);
                }
            }
        }
        return perimeter;
    }
    
    public int computePerimeter(int row, int col, int[][] grid){
        int value = 0;
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for(int[] dir: dirs){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            if(newRow<0 || newCol<0 || newRow>=grid.length || newCol>=grid[0].length || grid[newRow][newCol]==0)
                value++;
        }
        return value;
    }
}


// Better Solution
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    perimeter+=4;
                    if(i>0 && grid[i-1][j]==1)
                        perimeter-=2;
                    if(j>0 && grid[i][j-1]==1)
                        perimeter-=2;
                }
            }
        }
        return perimeter;
    }
}