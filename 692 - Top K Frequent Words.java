class Solution {
    Map<String,Integer> map;
    public List<String> topKFrequent(String[] words, int k) {
        map = new HashMap<String, Integer>();
        for(String word: words){
            map.put(word, map.getOrDefault(word,0)+1);    
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(new PriorityQueueComparator());
        for(String word: map.keySet()){
            heap.offer(word);
            if(heap.size()>k)
                heap.poll();
        }
        List<String> result = new ArrayList();
        while(!heap.isEmpty())
            result.add(0,heap.poll());
        return result;   
    }
    
    class PriorityQueueComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            return map.get(a).equals(map.get(b))?b.compareTo(a):map.get(a)-map.get(b);
        }
    }
}

