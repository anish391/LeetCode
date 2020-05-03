class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        char firstLetter = needle.charAt(0);
        int index = 0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==firstLetter){
                int hIdx = i, nIdx=0;
                boolean flag = false;
                //System.out.println(haystack.substring(i));
                while(hIdx<haystack.length() && nIdx<needle.length()){   
                    if(haystack.charAt(hIdx)!=needle.charAt(nIdx)){
                        //flag = false;
                        break;
                    }
                    hIdx++;
                    nIdx++;
                }
                if(nIdx==needle.length())
                    return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        char firstLetter = needle.charAt(0);
        int index = 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.charAt(i)==firstLetter){
                int j=0;
                boolean flag = false;
                //System.out.println(haystack.substring(i));
                for(j=0;j<needle.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j))
                        break;
                }
                if(j==needle.length())
                    return i;
            }
        }
        return -1;
    }
}