class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        Map<Character, Integer> map = new HashMap();
        for(char c: S.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        PriorityQueue<Character> pq = new PriorityQueue((a, b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){
            char c1 = pq.poll();
            char c2 = pq.poll();
            sb.append(c1);
            sb.append(c2);
            map.put(c1, map.get(c1)-1);
            map.put(c2, map.get(c2)-1);
            if(map.get(c1)>0)
                pq.add(c1);
            if(map.get(c2)>0)
                pq.add(c2);
        }
        //System.out.println(pq);
        if(!pq.isEmpty()){
            if(map.get(pq.peek())>1 || pq.peek()==sb.charAt(sb.length()-1))
                return "";
            else
                sb.append(pq.poll());
        }
        return sb.toString();
    }
}