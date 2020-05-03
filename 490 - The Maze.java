// DFS


class Solution {
    private int destRow, destCol;
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze[0].length==0)
            return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        destRow = destination[0];
        destCol = destination[1];
        return solveMaze(maze, visited, start[0], start[1]);
    }
    
    public boolean solveMaze(int[][] maze, boolean[][] visited, int row, int col){
        if(row<0 || col< 0 || row>=maze.length || col>=maze[0].length || visited[row][col])
            return false;
        if(row==destRow && col==destCol)
            return true;
        visited[row][col] = true;
        for(int[] direction: directions){
            int x = row;
            int y = col;
            while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0){
                x+=direction[0];
                y+=direction[1];
            }
            if(solveMaze(maze, visited, x-direction[0], y-direction[1]))
                return true;
        }
        return false;
    }
}

// BFS 

class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0]==destination[0] && current[1]==destination[1])
                return true;
            for(int[] direction: directions){
                int x = current[0]+direction[0];
                int y = current[1]+direction[1];
                while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0){
                    x+=direction[0];
                    y+=direction[1];
                }
                if(!visited[x-direction[0]][y-direction[1]]){
                    queue.add(new int[]{x-direction[0], y-direction[1]});
                    visited[x-direction[0]][y-direction[1]] = true;
                }
            }
        }
        return false;
    }
}