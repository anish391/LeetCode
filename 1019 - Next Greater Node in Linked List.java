/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<Integer> stack = new LinkedList<Integer>();
        int index = 0;
        ListNode current = head;
        while(current!=null){
            list.add(current.val);
            while((!stack.isEmpty())&& list.get(stack.peek())<current.val){
                list.set(stack.pop(),current.val);
            }
            stack.push(index);
            index++;
            current = current.next;
        }
        while(!stack.isEmpty()){
            list.set(stack.pop(),0);
        }
        int res[] = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}