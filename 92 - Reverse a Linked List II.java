/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode reverseStart = null, reverseEnd = null;
        ListNode current = head;
        ListNode prev = null;
        while(m>1){
            m--;
            n--;
            prev = current;
            current = current.next;
        }
        reverseStart = prev;
        reverseEnd = current;
        //System.out.println(reverseStart.val);
        while(n>0 && current!=null){
            n--;
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //reverseEnd = current.next;
        if(reverseStart!=null)
            reverseStart.next = prev;
        else
            head = prev;
        reverseEnd.next = current;
        //System.out.println(reverseStart.next.val);
        return head;
    }
}