class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+2);
        dp[0] = 0;
        for(int i=0;i<=n;i++){
            int left = Math.max(0,i-ranges[i]);
            int right = Math.min(i+ranges[i],n);
            for(int j=left+1;j<=right;j++){
                //Check if this range from(left..right) can be watered using less number of tapes than previous
                dp[j] = Math.min(dp[j], dp[left]+1);
            }
            //System.out.println(Arrays.toString(dp));
        }
        // If mimimum taps needed to water area 0..n is greater than n , it means we could not found minimum number of taps
        if(dp[n]>=n+2)
            return -1;
        return dp[n];
    }
}