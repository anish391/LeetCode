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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList();
        List<Integer> tree1 = new ArrayList();
        List<Integer> tree2 = new ArrayList();
        inorder(tree1, root1);
        inorder(tree2, root2);
        int i=0, j=0;
        while(i<tree1.size() && j<tree2.size()){
            if(tree1.get(i)<tree2.get(j))
                result.add(tree1.get(i++));
            else
                result.add(tree2.get(j++));
        }
        while(i<tree1.size()){
            result.add(tree1.get(i++));
        }
        while(j<tree2.size()){
            result.add(tree2.get(j++));
        }
        return result;
    }
    
    public void inorder(List<Integer> list, TreeNode root){
        if(root==null)
            return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}