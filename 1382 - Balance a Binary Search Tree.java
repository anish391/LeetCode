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
    List<Integer> values;
    public TreeNode balanceBST(TreeNode root) {
        values = new ArrayList();
        inorder(root);
        return balance(0, values.size()-1);
    }
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }
    
    public TreeNode balance(int start, int end){
        if(start>end)
            return null;
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = balance(start, mid-1);
        root.right = balance(mid+1, end);
        return root;
    }
}