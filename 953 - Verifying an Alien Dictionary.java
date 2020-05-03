class Solution {
    Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap();
        for(int i=0;i<order.length();i++)
            map.put(order.charAt(i), i);
        //System.out.println(map);
        //boolean verified = true;
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(!compare(word1,word2))
                return false;
        }
        return true;
    }
    
    private boolean compare(String word1, String word2){
        for(int index=0;index<word1.length() && index<word2.length();index++){
            if(map.get(word1.charAt(index))!=map.get(word2.charAt(index)))
                return map.get(word1.charAt(index))<map.get(word2.charAt(index));
        }
        return word1.length()<word2.length();
    }
}