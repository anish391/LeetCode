class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        int arraySum = 0, listSum = 0;
        for(int i=0;i<nums.length;i++)
            arraySum+=nums[i];
        for(int i=nums.length-1;i>=0;i--){
            listSum+=nums[i];
            arraySum-=nums[i];
            list.add(nums[i]);
            if(listSum>arraySum)
                break;
        }
        return list;
    }
}