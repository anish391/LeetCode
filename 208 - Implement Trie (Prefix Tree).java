// HashMap solution

class Trie {

    private TrieNode root;
    
    public class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWordEnd;
        
        public TrieNode(){
            children = new HashMap();
            isWordEnd = false;
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children.containsKey(c)){
                current = current.children.get(c);
            }
            else {
                TrieNode newNode = new TrieNode();
                current.children.put(c, newNode);
                current = newNode;
            }
            
        }
        current.isWordEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            if(current.children.containsKey(c)){
                TrieNode nextNode = current.children.get(c);
                current = nextNode;
            }
            else 
                return false;
        }
        return current.isWordEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int i=0;
        for(i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(current.children.containsKey(ch)){
                TrieNode nextNode = current.children.get(ch);
                current = nextNode;
            }
            else
                break;
        }
        return i==prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// Character Array Solution

class Trie {

    private TrieNode root;
    
    public class TrieNode{
        TrieNode[] children;
        boolean isWordEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
            isWordEnd = false;
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(current.children[ch-'a'] !=null){
                current = current.children[ch-'a'];
            }
            else {
                TrieNode newNode = new TrieNode();
                current.children[ch-'a'] = newNode;
                current = newNode;
            }
            
        }
        current.isWordEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(current.children[ch-'a'] !=null){
                TrieNode nextNode = current.children[ch-'a'];
                current = nextNode;
            }
            else 
                return false;
        }
        return current.isWordEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int i=0;
        for(i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(current.children[ch-'a']!=null){
                TrieNode nextNode = current.children[ch-'a'];
                current = nextNode;
            }
            else
                break;
        }
        return i==prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */