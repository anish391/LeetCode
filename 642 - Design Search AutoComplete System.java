class AutocompleteSystem {

    private Map<String, Integer> map = new HashMap();
    
    private class Node implements Comparable<Node>{
        private String sentence;
        private int times;
        
        public Node(String sentence, int times){
            this.sentence = sentence;
            this.times = times;
        }
        
        @Override
        public int compareTo(Node other){
            if(this.times==other.times)
                return this.sentence.compareTo(other.sentence);
            else
                return other.times - this.times;
        }
        
    }
    
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i=0;i<sentences.length;i++){
            map.put(sentences[i], times[i]);
        }
    }
    
    private String currentQuery = "";
    
    public List<String> input(char c) {
        List<String> result = new ArrayList();
        if(c=='#'){
            map.put(currentQuery, map.getOrDefault(currentQuery,0)+1); 
            currentQuery = "";
        }
        else{
            currentQuery += c;
            List<Node> list = new ArrayList();
            for(String key: map.keySet()){
                if(key.indexOf(currentQuery)==0){
                    list.add(new Node(key, map.get(key)));
                }
            }
            Collections.sort(list);
            for(int i=0;i<Math.min(3,list.size());i++)
                result.add(list.get(i).sentence);
        }
        
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */