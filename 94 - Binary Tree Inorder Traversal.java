#Iterative Solution

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)
            return list;
        //stack.push(root);
        TreeNode n = root;
        while(n != null){
            stack.push(n);
            n = n.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            node = node.right;
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }
}

# Recursive Solution

class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        TreeNode current = root;
        while(current!=null){
            if(current.left==null){
                list.add(current.val);
                current = current.right;
            }
            else{
                TreeNode predecessor = current.left;
                while(predecessor.right!=null && predecessor.right!=current)
                    predecessor = predecessor.right;
                if(predecessor.right==null){
                    predecessor.right = current;
                    current = current.left;
                }
                else{
                    predecessor.right=null;
                    list.add(current.val);
                    current = current.right;
                }
            }
        }
        return list;
    }
}