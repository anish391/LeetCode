class Solution {
    private int paths;
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        return traverse(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum) ;
    }
    
    public int traverse(TreeNode root, int sum){
        if(root==null)
            return 0;
        return (root.val==sum?1:0) + traverse(root.left, sum-root.val) + traverse(root.right, sum-root.val);
    }
}