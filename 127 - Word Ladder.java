class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        int length = beginWord.length();
        Map<String, List<String>> dict = new HashMap();
        Set<String> visited = new HashSet();
        for(String word: wordList){
            for(int i=0;i<length;i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,length);
                List<String> list = dict.getOrDefault(newWord, new ArrayList());
                list.add(word);
                dict.put(newWord, list);
            }
        }
        //System.out.println(dict);
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(beginWord,1));
        visited.add(beginWord);
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            int level = p.level;
            //System.out.println(word);
            for(int i=0;i<length;i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,length);
                for(String adjacentWord: dict.getOrDefault(newWord,new ArrayList<String>())){
                    if(adjacentWord.equals(endWord))
                        return level+1;
                    if(!visited.contains(adjacentWord)){
                        visited.add(adjacentWord);
                        queue.add(new Pair(adjacentWord, level+1));
                    }
                }
            }
        }
        return 0;
    }
    
    private class Pair{
        private String word;
        private int level;
        public Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
}