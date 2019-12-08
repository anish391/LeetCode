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
    List<String> result = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        //System.out.println(result);
        return result;
    }
    
    public void dfs(TreeNode root, String s){
        if(root!=null && root.left==null && root.right==null){
            s+=Integer.toString(root.val);
            result.add(s);
            return;
        }
        if(root==null)
            return;
        s+=root.val+"->";
        dfs(root.left,s);
        dfs(root.right,s);
        //System.out.println(s);
    }
}