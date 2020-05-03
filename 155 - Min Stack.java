class MinStack {

    private class Node{
        private int val;
        private int min;
        private Node next;
        
        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
        
        private Node(int val, int min){
            this(val, min, null);
        }
        
    }
    
    Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(head==null)
            head = new Node(x,x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {

    private Stack<Pair<Integer,Integer>> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            Pair pair = new Pair(x,x);
            stack.push(pair);
        }
        else{
            int currentMin = stack.peek().getValue();
            int newMin = Math.min(currentMin, x);
            Pair pair = new Pair(x, newMin);
            stack.push(pair);
        }
    }
    
    public void pop() {
        Pair pair = stack.pop();
    }
    
    public int top() {
        Pair<Integer,Integer> pair = stack.peek();
        return pair.getKey();
    }
    
    public int getMin() {
        Pair<Integer, Integer> pair = stack.peek();
        return pair.getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */