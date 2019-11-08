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
    private TreeNode ans;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root,p,q);
        return ans;
    }
    
    public boolean recurseTree(TreeNode node, TreeNode p, TreeNode q){
        if(node==null)
            return false;
        int left = recurseTree(node.left,p,q) ? 1:0;
        int right = recurseTree(node.right,p,q) ? 1:0;
        int mid = (node == p || node == q) ? 1:0;
        if(left+right+mid >= 2)
            ans = node;
        return left+right+mid>0;
    }
}