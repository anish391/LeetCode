public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> list = new HashSet<ListNode>();
        int index = 0;
        while(head!=null){
            //ListNode temp = new ListNode(-1);
            if(list.contains(head)){
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){
            if(fast==null || fast.next==null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}