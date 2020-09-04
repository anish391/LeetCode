
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
    long maxProd = Long.MIN_VALUE;
    int MOD = (int)1e9+7;
    public int maxProduct(TreeNode root) {
        int maxSum = dfsCount(root);
        dfsProduct(root, maxSum);
        return (int)(maxProd%MOD);
    }
    
    public int dfsCount(TreeNode root){
        if(root==null)
            return 0;
        int left = dfsCount(root.left);
        int right = dfsCount(root.right);
        return root.val+left+right;
    }
    
    public long dfsProduct(TreeNode root, int maxSum){
        if(root==null)
            return 0;
        long left = dfsProduct(root.left, maxSum);
        long right = dfsProduct(root.right, maxSum);
        long sum = root.val+left+right;
        long currentProd = sum*(maxSum-sum);
        maxProd = Math.max(maxProd, currentProd);
        return sum;
    }
}