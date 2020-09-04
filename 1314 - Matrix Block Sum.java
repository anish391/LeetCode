class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n=mat[0].length;
        int[][] rangeSum = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rangeSum[i+1][j+1] = rangeSum[i+1][j] + rangeSum[i][j+1] - rangeSum[i][j] + mat[i][j];
            }
        }
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1 = Math.max(0,i-K);
                int c1 = Math.max(0,j-K);
                int r2 = Math.min(i+K+1, m);
                int c2 = Math.min(j+K+1, n);
                result[i][j] = rangeSum[r2][c2] - rangeSum[r1][c2] - rangeSum[r2][c1] + rangeSum[r1][c1];
            }
        }
        return result;
    }
}