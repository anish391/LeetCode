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