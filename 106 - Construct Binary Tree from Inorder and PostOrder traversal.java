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
    private Map<Integer, Integer> map = new HashMap();
    private int[] postorder, inorder;
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postIndex = postorder.length-1;
        int idx = 0;
        for(int i: inorder)
            map.put(i, idx++);
        return helper(0, inorder.length-1);
    }
    
    public TreeNode helper(int l, int r){
        if(l>r)
            return null;
        TreeNode node = new TreeNode(postorder[postIndex--]);
        int mid = map.get(node.val);
        node.right = helper(mid+1,r);
        node.left = helper(l,mid-1);
        return node;
    }
}