class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0 || num<maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        rebalance();
    }
    
    public double findMedian() {
        PriorityQueue<Integer> biggerHeap = this.maxHeap.size()>this.minHeap.size()?maxHeap:minHeap;
        PriorityQueue<Integer> smallerHeap = this.maxHeap.size()>this.minHeap.size()?minHeap:maxHeap;
        if(biggerHeap.size()==smallerHeap.size())
            return (biggerHeap.peek()+smallerHeap.peek())/2.0;
        else
            return biggerHeap.peek();
    }
    
    public void rebalance(){
        PriorityQueue<Integer> biggerHeap = this.maxHeap.size()>this.minHeap.size()?maxHeap:minHeap;
        PriorityQueue<Integer> smallerHeap = this.maxHeap.size()>this.minHeap.size()?minHeap:maxHeap;
        if(biggerHeap.size()-smallerHeap.size() >= 2){
            smallerHeap.offer(biggerHeap.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */