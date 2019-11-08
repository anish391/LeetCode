#Iterative Preorder Traversal 9.12% solution

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val==val){
                return node;
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return null;
    }
}

# Recursive 100% solution

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val == val){
            return root;
        }
        if(root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}