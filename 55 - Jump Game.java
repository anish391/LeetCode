class Solution {
    public boolean canJump(int[] nums) {
        int currentFurthest=0;
        int finalPos=0;
        if(nums[0]==0 && nums.length>1)
            return false;
        for(int i=0;i<nums.length-1;i++){
            currentFurthest = Math.max(currentFurthest,i+nums[i]);
            if(i==finalPos)
                finalPos = currentFurthest;
        }
        return finalPos>=nums.length-1;
    }
}