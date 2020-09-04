class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList();
        int[] bMaxChars = new int[26];
        for(String b: B){
            int[] bCount = count(b);
            for(int i=0;i<26;i++)
                bMaxChars[i] = Math.max(bCount[i], bMaxChars[i]);
        }
        for(String a: A){
            int[] aChars = count(a);
            boolean isSubSet = true;
            for(int i=0;i<26;i++){
                if(aChars[i]<bMaxChars[i]){
                    isSubSet = false;
                    break;
                }
            }
            if(isSubSet)
                result.add(a);
                
        }
        return result;
    }
    
    public int[] count(String s){
        int[] ans = new int[26];
        for(int i=0;i<s.length();i++)
            ans[s.charAt(i)-'a']++;
        return ans;
    }
}