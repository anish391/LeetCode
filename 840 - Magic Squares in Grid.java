class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int magicalSquares = 0;
        for(int row=0;row<grid.length-2;row++){
            for(int col=0;col<grid[0].length-2;col++){
                if(magic(grid, row, col, row+3, col+3))
                    magicalSquares++;
            }
        }
        return magicalSquares;
    }
    
    public boolean magic(int[][] grid, int row, int col, int rowLen, int colLen){
        boolean[] visitedNumber = new boolean[10];
        for(int i=row;i<rowLen;i++){
            for(int j=col;j<colLen;j++){
                //System.out.print(grid[i][j]+" ");
                if(grid[i][j]<1 || grid[i][j]>9 || visitedNumber[grid[i][j]])
                    return false;
                visitedNumber[grid[i][j]] = true;
            }
            //System.out.println();
        }
        int diagonalSum = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
        int aDiagonalSum = grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col];
        if(diagonalSum!=aDiagonalSum)
            return false;
        int rowSum=0, colSum=0;
        for(int i=0;i<3;i++){
            rowSum = grid[row+i][col] + grid[row+i][col+1] + grid[row+i][col+2];
            colSum = grid[row][col+i] + grid[row+1][col+i] + grid[row+2][col+i];
            if(rowSum!=colSum || rowSum!=diagonalSum || colSum!=diagonalSum)
                return false;
        }
        return true;
    }
}