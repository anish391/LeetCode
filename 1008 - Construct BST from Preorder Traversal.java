class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode bstFromPreorder(int[] nums, int parent){
        if(i==nums.length || nums[i]>upper)
            return null;
        TreeNode root = new TreeNode(nums[i++]);
        root.left = bstFromPreorder(nums, root.val);
        root.right = bstFromPreorder(nums, parent);
        return root;
    }
}