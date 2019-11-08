class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++){
            sArray[s.charAt(i)-'a']++;
            tArray[t.charAt(i)-'a']++;
        }
        for(int i=0;i<sArray.length;i++){
            if(sArray[i]!=tArray[i])
                return false;
        }
        return true;
    }
}