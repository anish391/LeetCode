class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int maxFreq = Integer.MIN_VALUE;
        int result = -1;
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i: map.keySet()){
            if(map.get(i)>maxFreq){
                maxFreq = map.get(i);
                result = i;
            }
        }
        return result;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
