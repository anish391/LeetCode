class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                    queue.offer(new int[] {i,j});
                else if(grid[i][j]==1)
                    freshOranges++;
            }
        }
        if(freshOranges == 0) 
            return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();
                for(int[] dir: dirs){
                    int row = cell[0]+dir[0];
                    int col = cell[1]+dir[1];
                    if(row<0||col<0||row>=m||col>=n||grid[row][col]!=1)
                        continue;
                    queue.offer(new int[] {row,col});
                    freshOranges--;
                    grid[row][col] = 2;
                }
            }
            minutes++;
        }
        System.out.println(freshOranges);
        for(int[] i: grid)
            System.out.println(Arrays.toString(i));
        return freshOranges==0?minutes-1:-1;
    }
}