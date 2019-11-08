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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root==null)
            return list;
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> level = new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode node = deque.poll();
                if(node.left!=null)
                    deque.offer(node.left);
                if(node.right!=null)
                    deque.offer(node.right);
                level.add(node.val);
            }
            list.add(0, level);
        }
        return list;
    }
}