class Solution {
    
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int shortestBridge(int[][] A) {
        int flips = 0;
        boolean[][] visited = new boolean[A.length][A[0].length];
        Queue<int[]> queue = new LinkedList();
        boolean islandOneMarked = false;
        // Since there are only two seperate islands,
        // Using DFS mark all cells of one of the islands as 2.
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(islandOneMarked) // Island 1 has been explored
                    break;
                else if(A[i][j]==1){
                    dfs(i, j, A, visited, queue);
                    islandOneMarked = true;
                }
            }
        }
        // Queue will contain all cells of island 1.
        // Using BFS, if at any depth we find a number 1, it means that's the number of minimum flips required to reach the other island.
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();
                for(int[] direction: directions){
                    int row = cell[0]+direction[0];
                    int col = cell[1]+direction[1];
                    if(row>=0 && col>=0 && row<A.length && col<A[0].length && !visited[row][col]){
                        if(A[row][col]==1)
                            return flips;
                        visited[row][col] = true;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            flips++;
        }
        return -1;
    }
    
    public void dfs(int row, int col, int[][] A, boolean[][] visited, Queue<int[]> queue){
        if(row<0 || col<0 || row>=A.length || col>=A[0].length || visited[row][col] || A[row][col]!=1)
            return;
        visited[row][col] = true;
        A[row][col] = 2;
        queue.offer(new int[]{row,col});
        for(int[] direction: directions){
            int dr = direction[0];
            int dc = direction[1];
            dfs(row+dr, col+dc, A, visited, queue);
        }
    }
}