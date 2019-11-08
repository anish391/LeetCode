# Iterative Slow Solution
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = 0;
        boolean flag = true;
        if(root==null)
            return true;
        val = root.val;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val!=val){
                flag = false;
                break;
            }
            if(node.right!=null){
                if(node.right.val!=val){
                    flag = false;
                    break;
                }
                stack.push(node.right);
            }
            if(node.left!=null){
                if(node.left.val!=val){
                    flag = false;
                    break;
                }
                stack.push(node.left);
            }
        }
        if(flag==true){
            return true;
        }
        else{
            return false;
        }
    }
}

