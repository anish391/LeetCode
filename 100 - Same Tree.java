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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, false);
        String tree2 = preorder(t, false);
        return tree1.indexOf(tree2)>=0;
    }
    
    public String preorder(TreeNode t, boolean left){
        if(t==null){
            if(left)
                return "lnull";
            return "rnull";
        }
        return "#"+t.val+" " + preorder(t.left , true) + " " + preorder(t.right , false);
            
    }
    

}