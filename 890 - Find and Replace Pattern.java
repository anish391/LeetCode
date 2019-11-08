class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList();
        for(String word: words){
            int[] s = new int[26], p = new int[26];
            boolean same = true;
            for(int i=0;i<word.length();i++){
                if(s[word.charAt(i)-'a']!=p[pattern.charAt(i)-'a']){
                    same=false;
                    break;
                }
                else
                    s[word.charAt(i)-'a'] = p[pattern.charAt(i)-'a'] = i+1;
            }
            if(same)
                result.add(word);
        }
        return result;
    }
}