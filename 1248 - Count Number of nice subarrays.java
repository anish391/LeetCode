// For understanding: https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/508217/C%2B%2B%3A-Visual-explanation.-O(1)-space.-Two-pointers
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int total = 0;
        int oddNumbers = 0;
        while(end<nums.length){
            // If number is odd
            if((nums[end])&1==1){
                oddNumbers++;
                // If we meet condition for nice subarray. All subarrays up till first odd number are considered.
                if(oddNumbers>=k){
                    count = 1;
                    while((nums[start++]&1)==0){
                        count++;
                    }
                    total+=count;
                }
            }
            // If we encounter an even number but we have met nice subarray. We add the current count to total.
            // Since we are counting sub-arrays till the first odd number. 
            else if(oddNumbers>=k){
                total+=count;
            }
        }
    }
}