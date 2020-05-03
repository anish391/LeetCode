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
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root, null, null);
        return sum;
    }
    public void traverse(TreeNode root, TreeNode parent, TreeNode grandParent){
        if(root==null)
            return;
        if(grandParent!=null && grandParent.val%2==0)
            sum+=root.val;
        if(parent!=null){
            traverse(root.left,root,parent);
            traverse(root.right,root,parent);
        }
        else{
            traverse(root.left,root,null);
            traverse(root.right,root,null);
        }
    }
}