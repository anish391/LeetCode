/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        // Find the middle point of the linkedlist.
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the list after the midpoint. Break link between first and second half.
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode secondHalfRev = reverseList(secondHalf);
        // Join the first half and reversed second half in the required order.
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(firstHalf!=null || secondHalfRev!=null){
            if(firstHalf!=null){
                temp.next = firstHalf;
                temp = temp.next;
                firstHalf = firstHalf.next;
            }
            if(secondHalfRev!=null){
                temp.next = secondHalfRev;
                temp = temp.next;
                secondHalfRev = secondHalfRev.next;
            }
        }
        head = dummy.next;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prevNode = null;
        while(head!=null){
            ListNode nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }
}