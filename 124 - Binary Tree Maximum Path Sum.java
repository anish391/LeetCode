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
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return maxPath;
    }
    
    public int postorder(TreeNode root){
        if(root==null)
            return 0;
        int leftTree = Math.max(postorder(root.left),0);
        int rightTree = Math.max(postorder(root.right),0);
        int currentMax = root.val + leftTree + rightTree;
        maxPath = Math.max(currentMax, maxPath);
        return root.val+Math.max(leftTree,rightTree);
    }
}