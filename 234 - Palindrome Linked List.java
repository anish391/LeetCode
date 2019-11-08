class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null || head.next == null)
            return true;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverseList(slow.next);
        System.out.println(slow.next.val);
        slow = slow.next;
        while(slow!=null){
            if(slow.val!=head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode next = null;
        while(node!=null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    } 
}

## Solution with array recreated

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = head;
        if(head == null || head.next == null)
            return true;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        slow.next = reverseList(slow.next);
        System.out.println(slow.next.val);
        slow = slow.next;
        while(slow!=null){
            if(slow.val!=head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        mid.next = reverseList(mid.next);
        while(dummy!=null){
            System.out.println(dummy.val);
            dummy = dummy.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode next = null;
        while(node!=null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}