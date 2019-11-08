class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        TreeNode head = sortedArrayToBST(nums, 0, nums.length-1);
        return head;
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int low, int high){
        if(low>high)
            return null;
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, high);
        return node;
    }
}