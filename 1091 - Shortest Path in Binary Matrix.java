class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1]==1)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int []> queue = new LinkedList();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int answer = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();
                if(cell[0] == m-1 && cell[1] == n-1)
                    return answer+1;
                for(int[] dir: dirs){
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && grid[x][y]==0){
                        queue.add(new int[]{x,y});
                        visited[x][y] = true;
                    } 
                }
            }
            answer++;
        }
        return -1;
    }
    
}


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 && grid[grid.length-1][grid[0].length-1]==1)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Cell> queue = new LinkedList();
        queue.add(new Cell(0,0));
        visited[0][0] = true;
        int answer = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{-1,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Cell cell = queue.poll();
                if(cell.row == m-1 && cell.col == n-1)
                    return answer+1;
                for(int[] dir: dirs){
                    int x = cell.row + dir[0];
                    int y = cell.col + dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && grid[x][y]==0){
                        queue.add(new Cell(x,y));
                        visited[x][y] = true;
                    } 
                }
            }
            answer++;
        }
        return -1;
    }
    
    private class Cell{
        private int row;
        private int col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}