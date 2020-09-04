class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i=0;i<dp.length;i++){
            dp[i][i] = true;
            count++;
        }
        for(int i=0;i<dp.length-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                count++;
            }
        }
        for(int wordLength=3;wordLength<=s.length();wordLength++){
            for(int i=0;i<s.length()-(wordLength-1);i++){
                int j = i+wordLength-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}