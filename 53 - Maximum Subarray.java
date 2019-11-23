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

