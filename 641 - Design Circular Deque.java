class MyCircularDeque {
    
    private QueueNode head;
    private QueueNode tail;
    private int size;
    private int capacity;
    
    private class QueueNode {
        int value;
        QueueNode next;
        QueueNode prev;

        public QueueNode(int value, QueueNode next, QueueNode prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = 0;
        this.size = k;
        this.head = null;
        this.tail = null;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isEmpty()) {
            QueueNode qn = new QueueNode(value, null, null);
            this.head = qn;
            this.tail = qn;
            this.capacity++;
            return true;
        }
        else if(!isFull()) {
            QueueNode currentHead = this.head;
            QueueNode newHead = new QueueNode(value, currentHead, null);
            currentHead.prev = newHead;
            this.head = newHead;
            this.capacity++;
            return true;
        }
        else
            return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isEmpty()) {
            QueueNode qn = new QueueNode(value, null, null);
            this.head = qn;
            this.tail = qn;
            this.capacity++;
            return true;
        }
        else if(!isFull()) {
            QueueNode currentTail = this.tail;
            QueueNode newTail = new QueueNode(value, null, currentTail);
            currentTail.next = newTail;
            this.tail = newTail;
            this.capacity++;
            return true;
        }
        else
            return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        else if(this.capacity==1){
            this.head = null;
            this.tail = null;
            this.capacity--;
            return true;
        }
        else {
            QueueNode currentHead = this.head;
            this.head = currentHead.next;
            this.capacity--;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        else if(this.capacity==1) {
            this.head = null;
            this.tail = null;
            this.capacity--;
            return true;
        }
        else {
            QueueNode currentTail = this.tail;
            this.tail = currentTail.prev;
            this.capacity--;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(!isEmpty())
            return this.head.value;
        else
            return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(!isEmpty())
            return this.tail.value;
        else
            return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.capacity==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.capacity==this.size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */