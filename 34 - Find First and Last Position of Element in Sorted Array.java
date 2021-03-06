class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1,-1};
        int leftIndex = binarySearch(nums, 0 , nums.length, target, true);
        if(leftIndex==nums.length || nums[leftIndex]!=target)
            return targetRange;
        targetRange[0] = leftIndex;
        targetRange[1] = binarySearch(nums,0,nums.length, target, false)-1;
        //System.out.println(leftIndex);
        return targetRange;
    }
    
    public int binarySearch(int[] nums, int low, int high, int target, boolean leftMost){
        if(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target || (leftMost && target==nums[mid]))
                return binarySearch(nums,low,mid,target,leftMost);
            else
                return binarySearch(nums,mid+1,high,target,leftMost);
        }
        return low;
    }
}