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
    private TreeNode answer;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return answer;
    }
    
    public boolean lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return false;
        int left = lca(root.left,p,q)?1:0;
        int right = lca(root.right,p,q)?1:0;
        int mid = (root==p || root==q)?1:0;
        if(left+right+mid>=2)
            answer = root;
        return left+right+mid>0;
    }
}

// specifically for binary SEARCH tree Solution 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        return root;
        
    }
}