## Recursive Solution
class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, coins.length, amount);
    }
    
    public int helper(int[] coins, int m, int amount){
        if(amount==0)
            return 1;
        if(m<=0 && amount>=1)
            return 0;
        if(amount<0)
            return 0;
        return helper(coins, m, amount-coins[m-1]) + helper(coins, m-1, amount);  
    }
}

## DP Solution
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=coins.length;i++){
            dp[i][0]=1;
            for(int j=1;j<=amount;j++){
                int currentCoin = coins[i-1];
                int withoutCoin = dp[i-1][j];
                int withCoin = currentCoin<=j ? dp[i][j-currentCoin] : 0;
                dp[i][j] = withoutCoin + withCoin;
            }
        }
        return dp[coins.length][amount];
    }
}

## Optimized DP solution

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin: coins){
            for(int j=coin;j<=amount;j++)
                dp[j] += dp[j-coin];
        }
        return dp[amount];
    }
}