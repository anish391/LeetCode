//Top Down Approach

class Solution {
    private int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return coinChangeHelper(coins, amount, dp);
        //return ans;
    }
    
    public int coinChangeHelper(int[] coins, int amount, int[] dp){
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        if(dp[amount]!=0)
            return dp[amount];
        int minimum = Integer.MAX_VALUE;
        for(int coin: coins){
            int result = coinChangeHelper(coins, amount-coin, dp);
            minimum = result>=0 && result<minimum ? result+1:minimum;
        }
        dp[amount] = minimum==Integer.MAX_VALUE?-1:minimum;
        return dp[amount];
    }
}

// Bottom Up Approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin: coins){
                if(coin<=i)
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[amount]>amount?-1:dp[amount];
    }
}

