/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current!=null){
            length++;
            current = current.next;
        }
        int decimalValue = 0;
        current = head;
        while(current!=null){
            decimalValue+= current.val*Math.pow(2, length-1);
            current = current.next;
            length--;
        }
        return decimalValue;
    }
}