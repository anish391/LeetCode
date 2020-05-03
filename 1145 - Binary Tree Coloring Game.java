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
    private int leftTree=0, rightTree=0;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        depth(root,x);
        return Math.max(Math.max(leftTree,rightTree), n-leftTree-rightTree-1) >n/2;
    }
    
    public int depth(TreeNode root, int x){
        if(root==null)
            return 0;
        int left = depth(root.left,x);
        int right = depth(root.right,x);
        if(root.val==x){
            leftTree = left;
            rightTree = right;
        }
        return left+right+1;
            
    }
}