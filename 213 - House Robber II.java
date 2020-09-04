class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        // Convert into two house robber problems.
        if(nums.length==1)
            return nums[0];
        // If you include first house, you can't include last house in house robber.
        int[] includeFirstHouse = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] excludeFirstHouse = Arrays.copyOfRange(nums, 1, nums.length);
        
        return Math.max(robber(includeFirstHouse), robber(excludeFirstHouse));
    }
    
    public int robber(int[] nums) {
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