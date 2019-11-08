class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        boolean bool = false;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else{
                int j = map.get(nums[i]);
                if(Math.abs(i-j)>k)
                    bool=false;
                else
                    return true;
                map.put(nums[i],i);
            }
        }
        return bool;
    }
}