class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] dict = new int[26];
        int result = 0;
        for(char c: chars.toCharArray()){
            dict[c-'a']++;
        }
        for(String word: words){
            int count =0;
            int[] tdict = Arrays.copyOf(dict, dict.length);
            for(char c: word.toCharArray()){
                if(tdict[c-'a']>0){
                    tdict[c-'a']--;
                    count++;
                }
            }
            if(count==word.length())
                result+=count;
        }
        return result;
    }
}