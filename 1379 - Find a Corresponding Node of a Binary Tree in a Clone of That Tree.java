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
    //private TreeNode result;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode result = preorder(original, cloned, target);
        return result;
    }
    
    private TreeNode preorder(TreeNode original, TreeNode cloned, TreeNode target){
        if(original==null||cloned==null)
            return null;
        if(cloned.val == target.val)
            return cloned;
        TreeNode left = preorder(original.left, cloned.left, target);
        TreeNode right = preorder(original.right, cloned.right, target);
        return left==null?right:left;
    }
}