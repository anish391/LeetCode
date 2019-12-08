class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap();
        for(int i=0;i<keyboard.length();i++){
            map.put(keyboard.charAt(i),i);
        }
        int movement = Math.abs(0-map.get(word.charAt(0)));
        for(int i=0;i<word.length()-1;i++){
            movement += Math.abs(map.get(word.charAt(i))-map.get(word.charAt(i+1)));
        }
        return movement;
    }
}

class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] keys = new int[26];
        for(int i=0;i<keyboard.length();i++){
            keys[keyboard.charAt(i)-'a'] = i;
        }
        int movement = 0;
        int index = 0;
        for(int i=0;i<word.length();i++){
            movement += Math.abs(index-keys[word.charAt(i)-'a']);
            index = keys[word.charAt(i)-'a'];
        }
        return movement;
    }
}