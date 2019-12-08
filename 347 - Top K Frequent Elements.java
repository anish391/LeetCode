class Solution {
    Map<Integer, Integer> map;
    public List<Integer> topKFrequent(int[] nums, int k) {
        map = new HashMap();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        //Comparator<Integer> freqComparator = (a,b)-> map.get(a)-map.get(b);
        PriorityQueue<Integer> pq = new PriorityQueue(k,new FrequencyComparator());
        for(int i: map.keySet()){
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }
        List<Integer> result = new ArrayList();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        return result;
    }
    
    class FrequencyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return map.get(a)-map.get(b);
        }
    }
}