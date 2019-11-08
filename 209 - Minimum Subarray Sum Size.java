class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        //Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length && minLen>1;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum+= nums[j];
                if(sum>=s){
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen:0;
    }
}