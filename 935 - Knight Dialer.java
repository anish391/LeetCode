class Solution {
    int MOD = (int)1e9+7;
    public int knightDialer(int N) {
        if(N==0)
            return 0;
        long sum = 0;
        long[][][] memo = new long[N+1][4][3];
        
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                sum = (sum+paths(i,j,N, memo))%MOD;
            }
        }
        return (int)sum;
    }
    
    public long paths(int row, int col, int N, long[][][] memo){
        if(row<0 || col<0 || row>=4 || col>=3 || (row==3 && col!=1))
            return 0;
        if(N==1)
            return 1;
        if(memo[N][row][col]>0)
            return memo[N][row][col];
        long path = paths(row+2, col+1, N-1, memo) % MOD +
                    paths(row+2, col-1, N-1, memo) % MOD +
                    paths(row-2, col+1, N-1, memo) % MOD +
                    paths(row-2, col-1, N-1, memo) % MOD +
                    paths(row+1, col+2, N-1, memo) % MOD +
                    paths(row+1, col-2, N-1, memo) % MOD +
                    paths(row-1, col+2, N-1, memo) % MOD +
                    paths(row-1, col-2, N-1, memo) % MOD;
        memo[N][row][col] = path;
        return path;
    }
}