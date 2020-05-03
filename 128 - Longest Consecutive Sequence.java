//Time Efficient
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==1)
            return 1;
        Set<Integer> set = new HashSet();
        for(int num: nums)
            set.add(num);
        int maxLength = 0;        
        for(int num: set){
            if(!set.contains(num-1)){
                int currentNumber = num;
                int length = 1;
                while(set.contains(currentNumber+1)){
                    currentNumber++;
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
            
        }
        return maxLength;
    }
}


// Space efficient
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1 )
            return nums.length;
        Arrays.sort(nums);
        int anchor = 0;
        int maxLength=1;
        int length = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                continue;
            if(nums[i-1]+1==nums[i]){
                length++;
            }
            else{
                maxLength=Math.max(length, maxLength);
                length=1;
            }
        }
        return Math.max(length, maxLength);
    }
}