import java.util.Arrays;

public class Maze {
    private int[][] solution;
    private int N;
    private void solveMaze(int[][] maze){
        N = maze.length;
        solution = new int[N][N];
        if(!solveMazeUtil(maze, 0,0))
            System.out.println("No path");

    }

    private boolean solveMazeUtil(int[][] maze, int x, int y){
        if(x==N-1 && y==N-1){
            solution[x][y]=1;
            return true;
        }
        if(isSafe(maze, x, y)){
            solution[x][y]=1;
            if(solveMazeUtil(maze, x+1, y))
                return true;
            if(solveMazeUtil(maze, x, y+1))
                return true;
            solution[x][y]=0;
            return false;
        }
        return false;

    }

    private boolean isSafe(int[][] maze, int x, int y){
        if(x>=0 && x<N && y>=0 && y<N && maze[x][y]==1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } };
        Maze m = new Maze();
        for(int i=0;i<maze.length;i++){
            System.out.println(Arrays.toString(maze[i]));
        }

        m.solveMaze(maze);
        System.out.println("Solution");
        for(int i=0;i<m.solution.length;i++){
            System.out.println(Arrays.toString(m.solution[i]));
        }
    }
}
