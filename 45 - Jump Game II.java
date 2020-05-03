class Solution {
    public int jump(int[] nums) {
        int currentEnd=0, currentFarthest=0, jumps=0;
        for(int i=0;i<nums.length-1;i++){
            currentFarthest = Math.max(currentFarthest, i+nums[i]);
            if(i==currentEnd){
                jumps++;
                currentEnd = currentFarthest;
            }
        }
        return jumps;
    }
}