class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return inorder(root, false);
    }
    
    public int inorder(TreeNode root, boolean isLeft){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return isLeft?root.val:0;
        return inorder(root.left, true) + inorder(root.right, false);
    }
}
