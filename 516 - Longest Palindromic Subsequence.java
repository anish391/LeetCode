class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++){
            dp[i][i] = 1;
        }
        for(int l=2;l<=dp.length;l++){
            for(int i=0;i<dp.length-l+1;i++){
                int j = i+l-1;
                if(l==2 && s.charAt(i)==s.charAt(j))
                    dp[i][j] = 2;
                else if(s.charAt(i)==s.charAt(j))
                    dp[i][j] = 2 + dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][dp.length-1];
    }
}