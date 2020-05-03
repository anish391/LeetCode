class Solution {
    public int missingNumber(int[] nums) {
        int rangeSum=0, arraySum=0;
        for(int i=0;i<nums.length+1;i++){
            rangeSum += i;
        }
        for(int i=0;i<nums.length;i++){
            arraySum += nums[i];
        }
        return rangeSum-arraySum;
        
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int rangeSum=0, arraySum=0;
        for(int i=0;i<nums.length+1;i++){
            rangeSum += i;
            if(i<nums.length)
                arraySum+=nums[i];
        }
        return rangeSum-arraySum;
    }
}