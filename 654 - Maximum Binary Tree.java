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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    
    public TreeNode construct(int[] nums, int left, int right){
        if(left==right)
            return null;
        int maxIndex = max(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, left, maxIndex);
        root.right = construct(nums,maxIndex+1, right);
        return root;
    }
    
    public int max(int[] nums, int left, int right){
        int m = left;
        for(int i=left;i<right;i++){
            if(nums[i]>nums[m])
                m=i;
        }
        return m;
    }
}