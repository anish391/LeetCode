class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Mark 0, negative numbers and numbers greater than n as n+1 (Not to be considered)
        for(int i=0;i<n;i++){
            if(nums[i]<=0 || nums[i]>n)
                nums[i] = n+1;
        }
        // Mark other numbers as visited.
        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            // If number is greater than n, no cell is marked.
            if(num>n)
                continue;
            num--;
            if(nums[num]>0)
                nums[num] = nums[num] * -1;
            
        }
        // First unmarked index is the missing number
        for(int i=0;i<n;i++){
            if(nums[i]>0)
                return i+1;
        }
        return n+1;
    }
}