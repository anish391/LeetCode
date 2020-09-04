class Solution {
    int [] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recursiveRob(nums, nums.length-1);
    }
    
    public int recursiveRob(int[] nums, int size){
        if(size<0)
            return 0;
        if(dp[size]!=-1)
            return dp[size];
        dp[size] = Math.max(recursiveRob(nums,size-2)+nums[size], recursiveRob(nums,size-1)); 
        return dp[size];
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=1;i<nums.length;i++)
            dp[i+1] = Math.max(dp[i-1]+nums[i], dp[i]);
        return dp[nums.length];
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i=2;i<dp.length;i++){
            int currentHouse = nums[i-1];
            // dp[i-2] => Rob the current house and add to previous loot.
            // dp[i-1] => Skip current house since looting the previous house is profitable.
            dp[i] = Math.max(currentHouse+dp[i-2], dp[i-1]);
        }
        return dp[nums.length];
    }
}