class KthLargest {

    private int capacity;
    private PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        this.pq = new PriorityQueue();
        for(int num: nums)
            add(num);
    }
    
    public int add(int val) {
        if(pq.size()<capacity){
            pq.offer(val);
        }
        else {
            if(val>pq.peek()){
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */