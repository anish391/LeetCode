## Solution by Hashset
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null)
            return null;
        ListNode tempA = headA, tempB = headB;
        Set<ListNode> set = new HashSet<ListNode>();
        while(tempA!=null){
            set.add(tempA);
            tempA = tempA.next;
        }
        while(tempB!=null){
            if(set.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        return tempB;
    }
}


## Solution by setting end of list A to head of B and vice versa.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null)
            return null;
        ListNode a = headA, b = headB;
        while(a!=b){
            a = a==null ? headB:a.next;
            b = b==null ? headA:b.next;
        }
        return a;
    }
}