 class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> storage = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(storage.containsKey(complement))
                return new int[] {storage.get(complement),i};
            storage.put(nums[i],i);
        }
        
        return null;
    }
}

3 5 6 2 11 9 T=7

map = {
    3:0, complement = 4
    5:1, complement = 2
    6:2, complement = 1
    
}