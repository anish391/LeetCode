

class Solution {
    public int countNegatives(int[][] grid) {
        int negatives = 0;
        int r = grid.length-1;
        int c = 0;
        while(r>=0 && c<grid[0].length){
            if(grid[r][c]<0){
                r--;
                negatives += grid[0].length-c;
            }
            else{
                c++;
            }
        }
        return negatives;
    }
}