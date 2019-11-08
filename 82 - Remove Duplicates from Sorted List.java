class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        if(head == null)
            return null;
        int prev = head.val;
        while(head.next!=null && head!=null){
            int cur = head.next.val;
            if(cur==prev){
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
            prev = cur;
        }
        return dummy;
    }
}

## Recursive Solution is not necessary for LinkedList since it takes up O(n) space. Recursively solving trees gives O(logn) space