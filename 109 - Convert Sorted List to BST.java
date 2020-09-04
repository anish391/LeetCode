/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> sortedList = listToArray(head);
        TreeNode root = constructBST(sortedList, 0, sortedList.size());
        return root;
    }
    
    public List<Integer> listToArray(ListNode head){
        ListNode current = head;
        List<Integer> sortedList = new ArrayList();
        while(current!=null){
            sortedList.add(current.val);
            current = current.next;
        }
        return sortedList;
    }
    
    public TreeNode constructBST(List<Integer> sortedList, int start, int end){
        if(start<end){
            int mid = start+(end-start)/2;
            TreeNode node = new TreeNode(sortedList.get(mid));
            node.left = constructBST(sortedList, start, mid);
            node.right = constructBST(sortedList, mid+1, end);
            return node;
        }
        else
            return null;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return constructBST(head, null);
    }
    
    public TreeNode constructBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail)
            return null;
        while(fast!=tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = constructBST(head, slow);
        node.right = constructBST(slow.next, tail);
        return node;
    }
}