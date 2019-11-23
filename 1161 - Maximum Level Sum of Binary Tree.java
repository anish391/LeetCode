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
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int k=1,level=1;
        queue.offer(root);
        int result = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            int count = 0;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                count+=node.val;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            if(result<count){
                result=count;
                level=k;
            }
            k++;
        }
        return level;
    }
}