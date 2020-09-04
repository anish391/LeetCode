class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        // You start from each row and compute rectangles starting from that row till bottom of matrix.
        for(int startFrom=0;startFrom<m;startFrom++){
            int[] matRow = new int[n];
            Arrays.fill(matRow, 1);
            // Start from a row and go to the bottom of the matrix row-wise computing consecutive 1s in each row.
            for(int goTill=startFrom;goTill<m;goTill++){
                for(int col=0;col<n;col++){
                    matRow[col] &= mat[goTill][col];
                }
                result+=countOnesInRow(matRow);
            }
        }
        return result;
    }
    
    private int countOnesInRow(int[] matRow){
        int result=0;
        int length=0;
        for(int i=0;i<matRow.length;i++){
            length = matRow[i]==0?0:length+1;
            result+=length;
        }
        return result;
    }
}

// Youtube method https://www.youtube.com/watch?v=hrd-MEcZkOI

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        for(int i=0;i<m;i++){
            for(int j=n-2;j>=0;j--){
                mat[i][j] = mat[i][j]==1?mat[i][j+1]+1:mat[i][j];
            }
        }
        // You start from each row and compute rectangles starting from that row till bottom of matrix.
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int min = mat[i][j];
                // Start from a row and go to the bottom of the matrix row-wise computing consecutive 1s in each row.
                for(int k=i;k<m;k++){
                    min = Math.min(min, mat[k][j]);
                    result+=min;
                }
            }
        }
        return result;
    }
}