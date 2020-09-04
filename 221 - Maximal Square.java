class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int maxSquare = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if(matrix[i][j]=='1'){
                    int top = dp[i-1][j];
                    int topLeft = dp[i-1][j-1];
                    int left = dp[i][j-1];
                    // Implies a square.
                    if(top>=1 && topLeft>=1 && left>=1){
                        // If topLeft, left & top are equal, the side of square increases by 1.
                        if(top==topLeft && topLeft==left){
                            dp[i][j] = topLeft+1;
                        }
                        // Otherwise the square is formed by increasing side of minimum value.
                        // Check below example.
                        else{
                            dp[i][j] = Math.min(top, Math.min(topLeft, left))+1;
                        }
                    }
                    else{
                        dp[i][j] = matrix[i][j]-'0';
                    }
                }
                maxSquare = Math.max(maxSquare, dp[i][j]);
            }
        }
        return maxSquare==Integer.MIN_VALUE?0:maxSquare*maxSquare;
    }
}

/*
Example:
0 0 0 0 0    0 0 0 0 0
1 1 1 1 0    1 1 1 1 0
0 1 1 1 0 => 0 1 2 2 0
0 1 1 1 1    0 1 2 3 1
0 0 0 1 1    0 0 0 1 2
*/