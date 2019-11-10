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
    double res = 0;
    public double maximumAverageSubtree(TreeNode root) {
        preorder(root);
        return res;
    }
    
    public double[] preorder(TreeNode root){
        if(root==null)
            return new double[] {0,0};
        int sum = root.val;
        int num = 1;
        double[] left = preorder(root.left);
        double[] right = preorder(root.right);
        num += left[0] + right[0];
        sum += left[1] + right[1];
        res = Math.max(res, (double)sum/num);
        return new double[] {num, sum};
    }
}