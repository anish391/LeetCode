class MyHashMap {

    LinkedList[] buckets = new LinkedList[10000];
    
    private class Entry{
        int key;
        int value;
        
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
    }
    
    private int getIndex(int key){
        return Integer.hashCode(key) % buckets.length;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if(buckets[index]==null){
            buckets[index] = new LinkedList<Entry>();
            Entry entry = new Entry(key, value);
            buckets[index].add(entry);
        }
        else{
            LinkedList<Entry> entryList = buckets[index];
            for(Entry entry: entryList){
                if(entry.key==key){
                    entry.value = value;
                    return;
                }
            }
            Entry entry = new Entry(key,value);
            entryList.addLast(entry);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if(buckets[index]==null)
            return -1;
        else{
            LinkedList<Entry> entryList = buckets[index];
            for(Entry entry: entryList){
                if(entry.key==key)
                    return entry.value;
            }
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(buckets[index]==null)
            return;
        else{
            LinkedList<Entry> entryList = buckets[index];
            for(Entry entry: entryList){
                if(entry.key==key){
                    buckets[index].remove(entry);
                    return;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */