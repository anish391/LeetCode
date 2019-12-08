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
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> findLeaves(TreeNode root) {
        int maxDepth = maxDepth(root);
        for(int i=0;i<maxDepth;i++){
            List<Integer> leaves = new ArrayList();
            dfs(root, null, false, leaves);
            System.out.println(leaves);
            list.add(leaves);
        }
        
        return list;
    }
    
    public void dfs(TreeNode root, TreeNode parent, boolean isLeft, List<Integer> leaves){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            leaves.add(root.val);
            if(parent!=null && isLeft){
                parent.left=null;   
            }
            else if(parent!=null){
                parent.right=null;
            }
            return;
        }
        dfs(root.left, root, true, leaves);
        dfs(root.right, root, false, leaves);
    }
    
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+Math.max(left,right);
    }
}