class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap();
        Map<Character, Integer> indegree = new HashMap();
        StringBuilder result = new StringBuilder();
        if(words==null || words.length==0)
            return result.toString();
        for(String word: words){
            for(int i=0;i<word.length();i++){
                indegree.put(word.charAt(i), 0);
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            int minLength = Math.min(word1.length(), word2.length());
            for(int j=0;j<minLength;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1!=c2){
                    Set<Character> set = new HashSet();
                    if(graph.containsKey(c1))
                        set = graph.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        graph.put(c1, set);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        //System.out.println(graph);
        //System.out.println(indegree);
        Queue<Character> queue = new LinkedList();
        for(char c: indegree.keySet()){
            if(indegree.get(c)==0)
                queue.offer(c);
        }
        while(!queue.isEmpty()){
            char current = queue.poll();
            result.append(current);
            if(graph.containsKey(current)){
                for(char next: graph.get(current)){
                    indegree.put(next, indegree.get(next)-1);
                    if(indegree.get(next)==0)
                        queue.offer(next);
                }
            }
        }
        if(result.length()!=indegree.size())
            return "";
        return result.toString();
    }
}

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap();
        Map<Character, Integer> indegree = new HashMap();
        StringBuilder result = new StringBuilder();
        
        for(String word: words){
            for(int i=0;i<word.length();i++){
                indegree.put(word.charAt(i), 0);
                graph.put(word.charAt(i), new HashSet());
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            int minLength = Math.min(word1.length(), word2.length());
            for(int j=0;j<minLength;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1!=c2){
                    if(!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList();
        
        for(char key: indegree.keySet()){
            if(indegree.get(key)==0)
                queue.offer(key);
        }
        
        while(!queue.isEmpty()){
            char current = queue.poll();
            result.append(current);
            for(char next: graph.get(current)){
                indegree.put(next, indegree.get(next)-1);
                if(indegree.get(next)==0)
                    queue.offer(next);
            }
        }
        if(result.length()!=indegree.size())
            return "";
        return result.toString();
    }
}