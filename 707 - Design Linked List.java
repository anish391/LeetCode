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