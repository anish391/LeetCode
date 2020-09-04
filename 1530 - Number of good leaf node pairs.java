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
    int result;
    public int countPairs(TreeNode root, int distance) {
        if(root.left==null && root.right==null)
            return 0;
        result = 0;
        dfs(root, distance);
        return result;
    }
    
    
    // Each recursive call will return an array of distances where,
    // i => distance of node from parent.
    // distance[i] => number of leaf nodes in sub-tree.
    public int[] dfs(TreeNode root, int distance){
        if(root==null){
            return new int[distance+1];
        }
        // If the current node is a leaf, it as distance 1 from its parent.
        if(root.left==null && root.right==null){
            int[] leaves = new int[distance+1];
            leaves[1]++; // Since current leaf is distance 1 away from its parent, increment index 1.
            return leaves;
        }
        int[] leftLeaves = dfs(root.left, distance);
        int[] rightLeaves = dfs(root.right, distance);
        for(int l=1;l<leftLeaves.length;l++){
            for(int r=1;r<rightLeaves.length;r++){
                if(l+r<=distance){
                    result+= leftLeaves[l]*rightLeaves[r];
                }
            }
        }
        // The current count of leaves in left and right subtrees will have their distance increased by 1.
        // Since we will passing them to their parents.
        int[] leaves = new int[distance+1];
        for(int i=1;i<leaves.length-1;i++){
            leaves[i+1] = leftLeaves[i] + rightLeaves[i];
        }
        return leaves;
    }
}