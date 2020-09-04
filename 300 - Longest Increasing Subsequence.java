// Recursive Solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        return recursiveLIS(nums, Integer.MIN_VALUE, 0);
    }
    
    public int recursiveLIS(int[] nums, int prev, int currentIndex){
        if(currentIndex==nums.length)
            return 0;
        int withCurrent = 0;
        if(prev<nums[currentIndex])
            withCurrent = 1+recursiveLIS(nums, nums[currentIndex], currentIndex+1);
        int withoutCurrent = recursiveLIS(nums, prev, currentIndex+1);
        return Math.max(withCurrent, withoutCurrent);
    }
}

// DP Tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if(dp.length==0)
            return 0;
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        int count = 0;
        for(int i=0;i<dp.length;i++)
            count = Math.max(count,dp[i]);
        return count;
    }
}