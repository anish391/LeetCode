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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int zigzag = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(zigzag%2==0){
                    level.add(node.val);
                }
                else{
                    level.add(0,node.val);
                }
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            zigzag++;
            list.add(level);
        }
        return list;
    }
}