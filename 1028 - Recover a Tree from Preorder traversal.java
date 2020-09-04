/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack();
        int index = 0;
        while(index<S.length()){
            // Get depth of next node.
            int level = 0;
            while(index<S.length() && S.charAt(index)=='-'){
                index++;
                level++;
            }
            // Get value of next node.
            int value = 0;
            while(index<S.length() && S.charAt(index)!='-'){
                value = value*10 + (S.charAt(index)-'0');
                index++;
            }
            TreeNode node = new TreeNode(value);
            while(stack.size()>level)
                stack.pop();
            if(!stack.isEmpty()){
                if(stack.peek().left==null)
                    stack.peek().left = node;
                else
                    stack.peek().right = node;
            }
            stack.push(node);
        }
        while(stack.size()>1)
            stack.pop();
        return stack.pop();
    }
}