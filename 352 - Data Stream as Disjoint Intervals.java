class SummaryRanges {

    TreeMap<Integer, int[]> map;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val))
            return;
        if(map.size()==0)
            map.put(val, new int[]{val,val});
        
        // Key is interval start, value is interval pair
        Map.Entry<Integer, int[]> prev = map.lowerEntry(val);
        Map.Entry<Integer, int[]> next = map.higherEntry(val);
    
        boolean addPrev = prev!=null && prev.getValue()[1]+1>=val;
        boolean addNext = next!=null && val+1>=next.getKey();
        
        if(addPrev){
            if(addNext){
                map.remove(next.getKey());
                map.put(prev.getKey(), new int[]{prev.getKey(), next.getValue()[1]});
            }
            else{
                int intervalEnd = Math.max(prev.getValue()[1], val);
                map.put(prev.getKey(), new int[]{prev.getKey(), intervalEnd});
            }
        }
        else{
            if(addNext){
                map.remove(next.getKey());
                map.put(val, new int[]{val, next.getValue()[1]});
            }
            else{
                map.put(val, new int[]{val,val});
            }
        }
        
        
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[map.size()][2];
        int index = 0;
        for(int key: map.keySet()){
            result[index++] = map.get(key);
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */