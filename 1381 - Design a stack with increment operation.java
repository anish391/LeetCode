class CustomStack {
    
    private LinkedList<Integer> stack;
    private int capacity, size;
    
    public CustomStack(int maxSize) {
        this.stack = new LinkedList();
        this.capacity = 0;
        this.size = maxSize;
    }
    
    public void push(int x) {
        if(this.capacity<this.size){
            stack.addLast(x);
            this.capacity++;
        }
        
    }
    
    public int pop() {
        if(this.capacity!=0){
            this.capacity--;
            return stack.pollLast();    
        }
        else
            return -1;
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i<this.capacity;i++){
            this.stack.set(i, this.stack.get(i)+val);
        }
    }
}

// Lazy Increment

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */


class CustomStack {

    private Stack<Integer> stack;
    private int[] lazyIncrement; // Used to maintain the values that stack elements should be incremented by.
    private int size;
    
    public CustomStack(int maxSize) {
        stack = new Stack();
        lazyIncrement = new int[maxSize];
        size = maxSize;
    }
    
    public void push(int x) {
        if(stack.size() < size)
            stack.push(x);
    }
    
    public int pop() {
        if(stack.size()<=0)
            return -1;
        int incrementIndex = stack.size()-1;
        // Pass the value to be increment to lower elements of the stack by changing value of next lowest stack value.
        if(incrementIndex>0)
            lazyIncrement[incrementIndex-1]+=lazyIncrement[incrementIndex];
        int poppedValue = stack.pop() + lazyIncrement[incrementIndex];
        lazyIncrement[incrementIndex] = 0;
        return poppedValue;
    }
    
    public void increment(int k, int val) {
        // Find the top most element to increment between k and stack length.
        // Only increment the top most element. The subsequent elements will be incremented when they are popped.
        int topMostIndexToIncrement = Math.min(k, stack.size())-1;
        if(topMostIndexToIncrement>=0)
            lazyIncrement[topMostIndexToIncrement] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */