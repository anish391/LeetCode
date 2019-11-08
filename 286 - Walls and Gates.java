class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 0)
                    queue.offer(new int[] {i,j});
            }
        }
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] dir: dirs){
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if(row<0||col<0||row>=m||col>=n||rooms[row][col]==-1||rooms[row][col]<=rooms[cell[0]][cell[1]]+1)
                    continue;
                queue.offer(new int[] {row,col});
                rooms[row][col] = rooms[cell[0]][cell[1]] + 1;
            }
        }
        //return rooms;
    }
}