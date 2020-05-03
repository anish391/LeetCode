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
    List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList();
        inorder(root);
        return list.get(k-1);
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        while(true){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root = stack.pop();
            if(--k==0)
                return root.val;
            root = root.right;
        }
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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return -1;
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        while(current!=null){
            stack.push(current);
            current = current.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            k--;
            if(k==0)
                return node.val;
            node = node.right;
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
                
        }
        return -1;
    }
}