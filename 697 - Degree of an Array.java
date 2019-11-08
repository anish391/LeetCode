class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap();
        Map<Integer, Integer> right = new HashMap();
        Map<Integer, Integer> count = new HashMap();
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(left.get(x)==null)
                left.put(x,i);
            right.put(x,i);
            count.put(x, count.getOrDefault(x,0)+1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for(int i: count.keySet()){
            if(count.get(i)==degree){
                ans = Math.min(ans, right.get(i)-left.get(i)+1);
            }
        }
        return ans;
    }
}

### Faster Approach

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Triple> store = new HashMap<Integer, Triple>();
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(!store.containsKey(x)){
                store.put(x, new Triple(1,i,i));
            }
            else{
                Triple t = store.get(x);
                t.addCount();
                t.setTail(i);
            }
        }
        int max = 0;
        int shortest = 0;
        for(Map.Entry<Integer, Triple> entry: store.entrySet()){
            Triple t = entry.getValue();
            if(t.getCount()>=max){
                int s = t.getTail() - t.getHead() + 1;
                if(max!=t.getCount()){
                    max = t.getCount();
                    shortest = s;
                }
                else{
                    shortest = s<shortest?s:shortest;
                }
            }
        }
        return shortest;
    }
}

class Triple {
    int count;
    int head;
    int tail;
        
    public Triple(int count, int head, int tail) {
        this.count = count;
        this.head = head;
        this.tail = tail;
    }

    public int getCount() {
        return this.count;
    }    

    public int getHead() {
        return this.head;
    }

    public int getTail() {
        return this.tail;
    }
    
    public void addCount() {
        this.count++;
    }
    
    public void setHead(int head) {
        this.head = head;
    }
    
    public void setTail(int tail) {
        this.tail = tail;
    }  
}