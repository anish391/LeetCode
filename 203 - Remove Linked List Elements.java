class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val==val ? head.next:head;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        ListNode fakeHead = prev;
        prev.next = head;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val == val)
                prev.next = cur.next;
            else
                prev = prev.next;
            cur = cur.next;
        }
        return fakeHead.next;
    }
}