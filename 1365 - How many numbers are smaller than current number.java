class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap();
        int count = 0;
        for(int num: nums){
            if(!map.containsKey(num))
                map.put(num, count);
            count++;
        }
        for(int i=0;i<result.length;i++){
            result[i] = map.get(result[i]);
        }
        return result;
    }
}

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        // Get count of all numbers
        for(int num: nums)
            count[num]++;
        for(int i=0;i<nums.length;i++){
            int smaller = 0;
            // Iterate from zero till current number.
            for(int j=0;j<nums[i];j++){
                // Number of numbers smaller than current number is the sum of counts of smaller numbers.
                if(count[j]>0)
                    smaller+=count[j];
            }
            nums[i] = smaller;
        }
        return nums;
    }
}