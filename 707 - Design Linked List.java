class MyLinkedList {

    class Node{
        int val;
        Node next = null;
        public Node(int val){
            this.val = val;
        }
    }
    
    private Node head;
    private int size;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>=size)
            return -1;
        if(size==1){
            return head.val;
        }
        Node current = head;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head==null)
            head = new Node(val);
        else{
            Node n = new Node(val);
            n.next = head;
            head = n;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head==null)
            addAtHead(val);
        else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(val);
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        else if(index<=0){
            addAtHead(val);
        }
        else if(index==size){
            addAtTail(val);
        }
        else{
            Node n = new Node(val);
            Node current = head;
            for(int i=0;i<index-1;i++){
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return;
        }
        size--;
        if(index==0){
            head = head.next;
            return;
        }
        else{
            Node current = head;
            for(int i=0;i<index-1;i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
}

// Faster solution with tail pointer.

class MyLinkedList {
    
    class Node{
        int val;
        Node next;
        
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    
    private Node head;
    private Node tail;
    private int capacity;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.capacity = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>=this.capacity)
            return -1;
        else{
            if(index==0)
                return this.head.val;
            else if(index==this.capacity-1)
                return this.tail.val;
            else{
                int i=0;
                Node current = this.head;
                while(i<index && current!=null){
                    i++;
                    current = current.next;
                }
                return current.val;
            }
        }
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(this.head==null && this.tail==null){
            Node node = new Node(val, null);
            this.head = node;
            this.tail = node;
        }
        else{
            Node node = new Node(val, this.head);
            this.head = node;
        }
        this.capacity++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head==null && this.tail==null){
            addAtHead(val);
        }
        else{
            Node node = new Node(val, null);
            this.tail.next = node;
            this.tail = node;
        }
        this.capacity++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>this.capacity){
            return;
        }
        else{
            if(index==0)
                addAtHead(val);
            else if(index==this.capacity)
                addAtTail(val);
            else{
                Node current = this.head;
                int i = 0;
                while(i<index-1 && current!=null){
                    i++;
                    current = current.next;
                }
                Node next = current.next;
                current.next = new Node(val, next);
                this.capacity++;
            }
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //printList();
        if(index<0 || index>=this.capacity)
            return;
        else{
            if(index==0){
                this.head = this.head.next;
                this.capacity--;
            }
            else{
                Node current = this.head;
                int i=0;
                while(i<index-1 && current!=null){
                    i++;
                    current = current.next;
                }
                current.next = current.next.next;
                if(index==this.capacity-1)// Very important
                    this.tail = current;
                this.capacity--;
            }
        }
    }
    
    public void printList(){
        Node current = this.head;
        System.out.print("Capacity: "+ this.capacity+"% ");
        while(current!=null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */