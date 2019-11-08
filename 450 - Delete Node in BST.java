class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val>key)
            root.left = deleteNode(root.left, key);
        else if(root.val<key)
            root.right = deleteNode(root.right,key);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                root.val = findInorderMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    public int findInorderMin(TreeNode root){
        while(root.left!=null)
            root = root.left;
        return root.val;
    }
}