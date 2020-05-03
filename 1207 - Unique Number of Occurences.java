class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);
        System.out.println(map);
        for(int i: map.keySet()){
            if(!set.contains(map.get(i)))
                set.add(map.get(i));
            else
                return false;
        }
        return true;
    }
}

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);
        return map.size()==new HashSet<>(map.values()).size();
    }
}