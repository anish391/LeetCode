/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        Set<Pair<Integer, Integer>> visited = new HashSet();
        backtrack(robot, visited, 0, 0, 0);
    }

    public void backtrack(Robot robot, Set<Pair<Integer, Integer>> visited, int x, int y, int d){
        visited.add(new Pair(x,y));
        robot.clean();
        for(int i=0;i<4;i++){
            int newD = (d+i)%4;
            int dX = x + directions[newD][0];
            int dY = y + directions[newD][1];
            if(!visited.contains(new Pair(dX, dY)) && robot.move()){
                backtrack(robot, visited, dX, dY, newD);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    public void goBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}