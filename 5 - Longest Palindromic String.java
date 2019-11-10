class Solution {
    public String longestPalindrome(String s) {
        int maxLength = Integer.MIN_VALUE;
        String maxString = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
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