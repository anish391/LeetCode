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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inorder(root,list);
        int i=0, j=list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)==k)
                return true;
            if(list.get(i)+list.get(j)>k)
                j--;
            else if(list.get(i)+list.get(j)<k)
                i++;
        }
        return false;
        
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
