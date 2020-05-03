class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            int digitCount = 0;
            while(n!=0){
                n/=10;
                digitCount++;
            }
            if(digitCount%2==0)
                count++;
        }
        return count;
    }
}