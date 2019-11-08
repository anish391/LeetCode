# Use Dynamic Programming on Catalan Number

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+2];
        dp[0] = dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}

# Use Binomial Coefficient 

