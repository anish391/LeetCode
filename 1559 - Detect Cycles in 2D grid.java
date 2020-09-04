class Solution {
    
    public boolean containsCycle(char[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return false;
        } 
        boolean hasCycle = false;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    if(dfs(grid, visited, grid[i][j], i, j, -1)){
                        hasCycle = true;
                    }
                        
                }
            }
        }
        return hasCycle;
    }
    // 0: top, 1:right, 2:down, 3:left
    public boolean dfs(char[][] grid, boolean[][] visited, char ch, int r, int c, int prevDirection){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=ch)
            return false;
        if(visited[r][c])
            return true;
        visited[r][c] = true;
        boolean up = false, right = false, down = false, left = false;
        // If we previously didn't go down, go up
        if(prevDirection != 2)
            up = dfs(grid, visited, ch, r-1, c, 0);
        // If we previously didn't go left, go right.
        if(prevDirection != 3)
            right = dfs(grid, visited, ch, r, c+1, 1);
        // If we previously didn't go up, go down;
        if(prevDirection != 0)
            down = dfs(grid, visited, ch, r+1, c, 2);
        // If we previously didn't go right, go left.
        if(prevDirection != 1)
            left = dfs(grid, visited, ch, r, c-1, 3);
        return up||right||down||left;
    }
}