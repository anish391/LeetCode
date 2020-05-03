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
    public int deepestLeavesSum(TreeNode root) {
        int depth = maxDepth(root);
        //System.out.println(depth);
        int sum = deepestLeaves(root, 0, depth);
        return sum;
    }
    
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
    
    public int deepestLeaves(TreeNode root, int currentDepth, int depth){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null && currentDepth+1==depth)
            return root.val;
        int deepLeft = deepestLeaves(root.left, currentDepth+1, depth);
        int deepRight = deepestLeaves(root.right, currentDepth+1, depth);
        return deepLeft+deepRight;
    }
}