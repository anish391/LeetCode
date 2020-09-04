class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A.length];
        for(int col=0;col<dp[0].length;col++)
            dp[0][col] = A[0][col];
        for(int row = 1;row<dp.length;row++){
            for(int col=0;col<dp[0].length;col++){
                int left = col-1;
                int right = col+1;
                int top = row-1;
                if(col==0)
                    dp[row][col] = A[row][col]+Math.min(dp[top][col], dp[top][right]);
                else if(col==dp[0].length-1)
                    dp[row][col] = A[row][col]+Math.min(dp[top][col],dp[top][left]);
                else
                    dp[row][col] = A[row][col]+Math.min(dp[top][col], Math.min(dp[top][left], dp[top][right]));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int col=0;col<dp[0].length;col++)
            min = Math.min(min, dp[dp.length-1][col]);
        return min;
    }
}