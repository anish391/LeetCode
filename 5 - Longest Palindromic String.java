class Solution {
    public String longestPalindrome(String s) {
        int maxLength = Integer.MIN_VALUE;
        if(s.length()==1)
            return s;
        String maxString = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<=s.length();j++){
                String sub = s.substring(i,j);
                if(isPalindrome(sub) && maxLength<sub.length()){
                    maxLength = sub.length();
                    maxString = sub;
                }
            }
        }
        return maxString;
    }
    
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLen = 1;
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                start = i;
                maxLen = 2;
                dp[i][i+1] = true;
            }
        }
        for(int wordLen=3;wordLen<=s.length();wordLen++){
            for(int i=0;i<s.length()-wordLen+1;i++){
                int j = i+wordLen-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    start = i;
                    maxLen = wordLen;
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}