/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
            return null;
        Node current = head;
        while(current!=null){
            Node next = current.next;
            // If no child move on.
            if(current.child==null){
                current = current.next;
                continue;
            }
            // If child exists go till end of list.
            Node child = current.child;
            while(child.next!=null)
                child = child.next;
            // Append next node of current to end of child
            child.next = current.next;
            // If next node isn't null, assign prev pointer
            if(current.next!=null)
                current.next.prev = child;
            current.next = current.child;
            current.child.prev = current;
            current.child = null;
        }
        return head;
    }
}