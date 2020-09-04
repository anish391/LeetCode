class Solution {
    
    private int[][] directions = {{-1,0}, {0,1}, {1,0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return result;
        int m=matrix.length;
        int n=matrix[0].length;
        Queue<int[]> pacificQueue = new LinkedList();
        Queue<int[]> atlanticQueue = new LinkedList();
        boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
        boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
        // Horizontal edge for both atlantic and pacific ocean.
        for(int col=0;col<n;col++){
            pacificQueue.offer(new int[]{0, col});
            pacificVisited[0][col] = true;
            atlanticQueue.offer(new int[]{m-1, col});
            atlanticVisited[m-1][col] = true;
        }
        // Vertical edge for both atlantic and pacific ocean.
        for(int row=0;row<m;row++){
            pacificQueue.offer(new int[]{row, 0});
            pacificVisited[row][0] = true;
            atlanticQueue.offer(new int[]{row, n-1});
            atlanticVisited[row][n-1] = true;
        }
        bfs(pacificQueue, matrix, pacificVisited, m, n);
        bfs(atlanticQueue, matrix, atlanticVisited, m, n);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){ 
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return result;
    }
    
    public void bfs(Queue<int[]> queue, int[][] matrix, boolean[][] visited, int m, int n){
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int cellX = cell[0];
            int cellY = cell[1];
            for(int[] direction: directions){
                int newX = cellX + direction[0];
                int newY = cellY + direction[1];
                if(newX<0 || newY<0 || newX>=m || newY>=n || visited[newX][newY] || matrix[cellX][cellY] > matrix[newX][newY])
                    continue;
                visited[newX][newY] = true;
                queue.offer(new int[]{newX, newY});
            }
        }
    }
    
}


class Solution {
    
    private int[][] directions = {{-1,0}, {0,1}, {1,0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return result;
        int m=matrix.length;
        int n=matrix[0].length;
        
        boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
        boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
        
        // Horizontal edge for both atlantic and pacific ocean.
        for(int col=0;col<n;col++){
            dfs(matrix, pacificVisited, Integer.MIN_VALUE, 0, col);
            dfs(matrix, atlanticVisited, Integer.MIN_VALUE, m-1, col);
        }
        // Vertical edge for both atlantic and pacific ocean.
        for(int row=0;row<m;row++){
            dfs(matrix, pacificVisited, Integer.MIN_VALUE, row, 0);
            dfs(matrix, atlanticVisited, Integer.MIN_VALUE, row, n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){ 
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return result;
    }
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;
        if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length || visited[x][y] || matrix[x][y]<height)
            return;
        visited[x][y] = true;
        for(int[] direction: directions){
            dfs(matrix, visited, matrix[x][y], x+direction[0], y+direction[1]);
        }
    }
}