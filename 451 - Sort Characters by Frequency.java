class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry entry = pq.poll();
            for(int i=0;i<(int)entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c: map.keySet())
            pq.add(c);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            for(int i=0;i<map.get(ch);i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}