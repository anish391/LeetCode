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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode current = stack.peek();
            if(prev==null || prev.left == current || prev.right == current){
                if(current.left!=null)
                    stack.push(current.left);
                else if(current.right!=null)
                    stack.push(current.right);
                else{
                    TreeNode node = stack.pop();
                    list.add(node.val);
                }
            }
            else if(current.left == prev){
                if(current.right!=null)
                    stack.push(current.right);
                else{
                    TreeNode node = stack.pop();
                    list.add(node.val);
                }
            }
            else if (current.right == prev){
                TreeNode node = stack.pop();
                list.add(node.val);
            }
            prev = current;
        }
        return list;
    }
}