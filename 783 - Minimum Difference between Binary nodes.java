class Solution {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    
    public int minDiffInBST(TreeNode root) {
        if(root==null)
            return min;
        minDiffInBST(root.left);
        if(prev!=null)
            min = Math.min(min, root.val-prev);
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }
}