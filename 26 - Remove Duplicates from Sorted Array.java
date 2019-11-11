class Solution {
    public int removeDuplicates(int[] nums) {
        int anchor = 0;
        if(nums.length==0)
            return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[anchor]!=nums[i])
                nums[++anchor] = nums[i];
        }
        return anchor+1;
    }
}