class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return null;
        if(root.val < L)
            return trimBST(root.right, L, R);
        if(root.val > R)
            return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}

## Iterative Solution

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return root;
        while((root.val<L || root.val>R)&&root!=null){
            if(root.val < L)
                root = root.right;
            if(root.val > R)
                root = root.left;
        }
        TreeNode dummy = root;
        while(dummy!=null){
            while(dummy.left!=null && dummy.left.val<L){
                dummy.left = dummy.left.right;
            }
            dummy = dummy.left;
        }
        dummy = root;
        while(dummy!=null){
            while(dummy.right!=null && dummy.right.val>R){
                dummy.right = dummy.right.left;
            }
            dummy = dummy.right;
        }
        return root;
    }
}