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
    private int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left+right);
        return Math.max(left,right)+1;
    }
}