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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        TreeNode current = root;
        while(current!=null){
            // Current node in inorder sequence. Print/add to list.
            // After printing, go to right i.e. inorder next.
            if(current.left==null){
                result.add(current.val);
                current = current.right;
            }
            else{
                // Any nodes left child is its inorder predecessor. Inorder successor is right most child of leftmost tree. 
                TreeNode pred = current.left;
                while(pred.right!=null && pred.right!=current) // Second condition helps reach inorder successor.
                    pred = pred.right;
                // Set inorder successor here and move left.
                if(pred.right==null){
                    pred.right = current;
                    current = current.left;
                }
                // pred's is pointing to inorder successor. 
                else{
                    result.add(current.val);
                    current = current.right;
                    pred.right = null;
                }
            }   
        }
        return result;
    }
}