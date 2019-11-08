 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        boolean heightCheck = Math.abs(treeHeight(root.left)-treeHeight(root.right)) < 2;
        return heightCheck && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int treeHeight(TreeNode root){
        if(root==null)
            return -1;
        return 1+Math.max(treeHeight(root.left),treeHeight(root.right));
    }
}