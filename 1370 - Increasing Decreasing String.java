class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        int maxCharCount = Integer.MIN_VALUE;
        for(char c: s.toCharArray()){
            count[c-'a']++;
            maxCharCount = Math.max(maxCharCount, count[c-'a']);
        }
        boolean even = true;
        for(int i=0;i<maxCharCount;i++){
            if(even){
                for(int j=0;j<26;j++){
                    if(count[j]>0){
                        sb.append((char)(j+'a'));
                        count[j]--;
                    }
                }        
            }
            else{
                for(int j=25;j>=0;j--){
                    if(count[j]>0){
                        sb.append((char)(j+'a'));
                        count[j]--;
                    }
                }
            }
            even = !even;            
        }
        return sb.toString();

    }
}