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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        helper(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root==null)
            return;
        else if(root.left==null && root.right==null && sum-root.val==0){
            path.add(root.val);
            result.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        else{
            path.add(root.val);
            helper(root.left, sum-root.val, path, result);
            helper(root.right, sum-root.val, path, result);
            path.remove(path.size()-1);
        }
    }
}