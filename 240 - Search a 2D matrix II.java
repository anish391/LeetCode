class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length == 0)
            return false;
        int row = 0, col = matrix[0].length-1;
        while(row<matrix.length && col>-1){
            if(matrix[row][col]==target)
                return true;
            else if(target< matrix[row][col])
                col--;
            else
                row++;
        }
        return false;
    }
}