/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        if(root==null || p==null)
            return null;
        if(p.right!=null){
            TreeNode temp = p.right;
            while(temp.left!=null)
                temp = temp.left;
            return temp;
        }
        else{
            TreeNode temp = root;
            while(temp!=null){
                if(p.val<temp.val){
                    successor = temp;
                    temp = temp.left;
                }
                else if(p.val>temp.val){
                    temp = temp.right;
                }
                else
                    break;
            }
        }
        return successor;
    }
}