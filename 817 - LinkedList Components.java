/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        Set<Integer> set = new HashSet();
        for(int i: G)
            set.add(i);
        ListNode node = head;
        while(node!=null){
            if(set.contains(node.val)&& (node.next==null||!set.contains(node.next.val)))
                count++;
            node = node.next;
        }
        return count;
    }
}