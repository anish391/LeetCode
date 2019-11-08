class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a,b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy; 
        for(ListNode node: lists){
            if(node!=null)
                queue.add(node);
        }
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}

## Recursive Solution 


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        return merge(lists, 0 , lists.length-1);
    }
    
    public ListNode merge(ListNode[] lists, int start, int end){
         if (start == end) {
            return lists[start];
        } else if (start < end){
            int mid = (end - start) / 2 + start;
            ListNode left = merge(lists, start, mid);
            ListNode right = merge(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }   
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        else if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}