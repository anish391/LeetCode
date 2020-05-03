class Solution {
    public int maxSubArray(int[] nums) {
        int start=0, end=0;
        int sum = nums[0];
        int oldsum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(oldsum+nums[i]>nums[i]){
                oldsum+= nums[i];
            }
            else{
                oldsum = nums[i];
            }
            if(oldsum>sum){
                sum = oldsum;
            }
        }
        System.out.println(sum);
        return sum;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>0)
                nums[i] += nums[i-1];
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }
}