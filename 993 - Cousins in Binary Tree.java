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
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root==null)
            return false;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean X = false;
            boolean Y = false;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.val == x)
                    X = true;
                if(node.val == y)
                    Y = true;
                if(node.left!=null && node.right!=null){
                    if(node.left.val == x && node.right.val==y)
                        return false;
                    if(node.left.val == y && node.right.val==x)
                        return false;
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                if(X&&Y)
                    return true;
            }
        }
        return false;
    }
}