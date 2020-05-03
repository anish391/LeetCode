class MovingAverage {
    private Queue<Integer> queue;
    private double sum = 0;
    private int capacity;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList();
        capacity = size;
    }
    
    public double next(int val) {
        if(queue.size()==capacity)
            sum-=queue.poll();
        sum+=val;
        queue.add(val);
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */