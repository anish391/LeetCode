class HitCounter {
    private LinkedList<Integer> queue;
    private int getHitCounter;
    /** Initialize your data structure here. */
    public HitCounter() {
        getHitCounter = 0;
        queue = new LinkedList();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
        System.out.println(queue);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp - queue.peek()>=300)
            queue.poll();
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

class HitCounter {
    private int[] hits;
    private int[] time;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        time = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(time[index]!=timestamp){
            time[index] = timestamp;
            hits[index] = 1;
        }
        else{
            hits[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int numberOfHits = 0;
        for(int i=0;i<300;i++){
            if(timestamp-time[i]<300)
                numberOfHits+=hits[i];
        }
        return numberOfHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

class HitCounter {

    private int currentTime;
    private Deque<Integer> queue;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        currentTime = 0;
        queue = new ArrayDeque();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp-queue.peek()>=300)
            queue.poll();
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */