/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int len = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        len = 0;
        longestUnivaluePath(root, root.val);
        return len;
    }
    
    public int longestUnivaluePath(TreeNode root, int val){
        if(root==null)
            return 0;
        int left = longestUnivaluePath(root.left, root.val);
        int right = longestUnivaluePath(root.right, root.val);
        len = Math.max(len, left+right);
        if(val == root.val)
            return Math.max(left,right)+1;
        return 0;
    }
}