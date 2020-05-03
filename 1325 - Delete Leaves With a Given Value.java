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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root, target);
    }
    
    public TreeNode helper(TreeNode root, int target){
        if(root.left!=null)
            root.left = helper(root.left, target);
        if(root.right!=null)
            root.right = helper(root.right, target);
        return root.val==target && root.left==null && root.right==null ? null:root;
    }
}