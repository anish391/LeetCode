class WordDictionary {

    private Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.children[c-'a']==null){
                current.children[c-'a'] = new Trie();
                current = current.children[c-'a'];
            }
            else{
                current = current.children[c-'a'];
            }
        }
        current.isWordEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie current = root;
        return dfs(word, 0, current);
    }
    
    public boolean dfs(String word, int start, Trie current){
        if(start==word.length())
            return current.isWordEnd;
        char ch = word.charAt(start);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(current.children[i]!=null)
                    if(dfs(word, start+1, current.children[i]))
                        return true;
            }
        }
        else{
            if(current.children[ch-'a']!=null)
                return dfs(word, start+1, current.children[ch-'a']);
            else 
                return false;
        }
        return false;
    }
    
    class Trie{
        Trie[] children;
        boolean isWordEnd;
        public Trie(){
            children = new Trie[26];
            isWordEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */