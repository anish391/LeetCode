class Solution {
    private int[] colors = {1,2,3};
    private int mod = (int)1e9+7;
    
    public int numOfWays(int n) {
        int[][][][] dp = new int[n+1][4][4][4];
        return dfs(n, 0, 0, 0, dp);
    }
    
    public int dfs(int n, int aPrev, int bPrev, int cPrev, int[][][][] dp){
        if(n==0)
            return 1;
        if(dp[n][aPrev][bPrev][cPrev]>0)
            return dp[n][aPrev][bPrev][cPrev];
        int answer = 0;
        for(int colorA: colors){
            if(colorA==aPrev)
                continue;
            for(int colorB: colors){
                if(colorB==bPrev || colorB==colorA)
                    continue;
                for(int colorC: colors){
                    if(colorC==cPrev || colorC==colorB)
                        continue;
                    answer += dfs(n-1, colorA, colorB, colorC, dp);
                    answer %= mod;
                }
            }
        }
        dp[n][aPrev][bPrev][cPrev] = answer;
        return answer;
    }
}

class Solution {
    private int numWays;
    public int numOfWays(int n) {
        long a121=6, a123=6;
        long b121, b123;
        long mod = (long)1e9+7;
        for(int i=1;i<n;i++){
            b121 = a121*3 + a123*2;
            b123 = a121*2 + a123*2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int)((a121+a123)%mod);
    }
    
}