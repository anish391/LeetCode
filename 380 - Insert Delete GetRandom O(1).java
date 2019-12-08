class RandomizedSet {

    private Map<Integer,Integer> map = new HashMap();
    private List<Integer> list = new ArrayList();
    private Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val,list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int currentLast = list.get(list.size()-1);
            list.set(index, currentLast);
            map.put(currentLast, index);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int index =  random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */