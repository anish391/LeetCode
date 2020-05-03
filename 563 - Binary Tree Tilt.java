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
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        postorder(root);
        return tilt;
    }
    
    public int postorder(TreeNode root){
        if(root==null)
            return 0;
        int left = postorder(root.left);
        int right = postorder(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}