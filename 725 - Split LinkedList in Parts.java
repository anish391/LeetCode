	/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        ListNode current = root;
        int length = 0;
        while(current!=null){
            current = current.next;
            length++;
        }
        int divisions = length/k;
        int remainder = length%k;
        ListNode prev = null;
        current = root;
        for(int i=0;i<k && current!=null;i++,remainder--){
            result[i] = current;
            for(int j=0;j<divisions+(remainder>0?1:0);j++){
                prev = current;
                current = current.next;
            }
            prev.next=null;
        }
        return result;
    }
}