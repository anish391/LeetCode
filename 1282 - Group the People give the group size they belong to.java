class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap();
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<groupSizes.length;i++){
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList());
            // If the group size is full, add it to result list and start with a new group(list).
            if(list.size()==groupSizes[i]){
                result.add(list);
                list = new ArrayList();
            }
            list.add(i);
            map.put(groupSizes[i],list);
        }
        for(int key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}