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
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        return helper(root, root.val);
    }
    
    public int helper(TreeNode root, int value){
        if(root==null)
            return 0;
        int good = 0;
        if(value<=root.val)
            good++;
        int leftGood = helper(root.left, Math.max(value, root.val));
        int rightGood = helper(root.right, Math.max(value,root.val));
        return good+leftGood+rightGood;
        
    }
}