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