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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    
    public boolean sameTree(TreeNode s, TreeNode t){
        if(s==null && t == null)
            return true;
        if(s==null || t==null)
            return false;
        return s.val==t.val && sameTree(s.left,t.left) && sameTree(s.right, t.right);
    }
    
    public boolean traverse(TreeNode s, TreeNode t){
        return s!= null && (sameTree(s,t)||traverse(s.left,t)||traverse(s.right,t));
    }   
}