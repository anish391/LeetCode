class Solution {
    public int numberOfSubstrings(String s) {
        int anchor = 0;
        int[] charCount = {0,0,0};
        int result = 0; 
        for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)-'a']++;
            while(charCount[0]>0 && charCount[1]>0 && charCount[2]>0)
                charCount[s.charAt(anchor++)-'a']--;
            result+=anchor;
        }
        return result;
    }
}