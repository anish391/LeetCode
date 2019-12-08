class RandomizedCollection {

    private Map<Integer, Set<Integer>> map = new HashMap();
    private List<Integer> list = new ArrayList();
    private Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val))
            map.put(val, new HashSet());
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size()==1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size()==0)
            return false;
        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);
        int lastElement = list.get(list.size()-1);
        list.set(removeIndex, lastElement);
        map.get(lastElement).add(removeIndex);
        map.get(lastElement).remove(list.size()-1);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */