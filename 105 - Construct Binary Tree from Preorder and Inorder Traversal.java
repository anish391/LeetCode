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
    Map<Integer,Integer> map = new HashMap();
    int preIndex = 0;
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx = 0;
        for(int i: inorder)
            map.put(i, idx++);
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0, inorder.length);
    }
    
    public TreeNode helper(int l, int r){
        if(l==r)
            return null;
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int mid = map.get(node.val);
        node.left = helper(l , mid);
        node.right = helper(mid+1,r);
        return node;
    }
}