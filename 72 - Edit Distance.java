class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0)
                    dp[i][j] = 0;
                else if(i==0 && j!=0)
                    dp[i][j] = j;
                else if(i!=0 && j==0)
                    dp[i][j] = i;
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = Math.min(delete, Math.min(insert,replace)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0] = i;
        for(int i=0;i<dp[0].length;i++)
            dp[0][i] = i;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int delete = dp[i-1][j];
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = Math.min(delete, Math.min(insert,replace)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}