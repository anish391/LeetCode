class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i: map.keySet())
            if(map.get(i)==1)
                return i;
        return -1;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i: nums)
            result^=i;
        return result;
    }
}