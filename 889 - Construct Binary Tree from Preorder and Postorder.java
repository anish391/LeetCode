class Solution {
    private int preIndex=0, postIndex=0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if(root.val!=post[postIndex])
            root.left = constructFromPrePost(pre,post);
        if(root.val!=post[postIndex])
            root.right = constructFromPrePost(pre,post);
        postIndex++;
        return root;
    }
}