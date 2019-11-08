class LRUCache {

    private Deque<Integer> deque;
    private HashMap<Integer,Integer> map;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new ArrayDeque<Integer>(capacity);
        map = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            //System.out.println("GET START "+deque);
            deque.remove(key);
            int result = map.get(key);
            deque.addFirst(key);
            //System.out.println("GET "+ deque);
            return result;   
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //System.out.println("PUT "+key);
        if(map.containsKey(key)){
            deque.remove(key);
            map.put(key,value);
            deque.addFirst(key);
        }
        else{
            if(capacity==0){
                map.remove(deque.removeLast());
                capacity++;
            }
            map.put(key,value);
            deque.addFirst(key);
            capacity--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */