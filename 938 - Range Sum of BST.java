# Iterative Slow solutions

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int count = 0;
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.val>=L && node.val<=R){
                    count += node.val;
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return count;
    }
}

# Recursive Fast solutions

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
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        rng(root,L,R);
        return ans;
    }
    
    public void rng(TreeNode root, int L, int R){
        if(root==null){
            return;
        }
        if(L<=root.val && root.val<=R){
            ans+=root.val;
        }
        if(L < root.val){
            rangeSumBST(root.left, L, R);
        }
        if(root.val < R){
            rangeSumBST(root.right, L, R);
        }
    }
}
