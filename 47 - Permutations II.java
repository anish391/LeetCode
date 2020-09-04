class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        permutation(nums, map, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void permutation(int[] nums, Map<Integer, Integer> map, ArrayList<Integer> current, List<List<Integer>> result){
        if(current.size()==nums.length){
            result.add(new ArrayList(current));
            return;
        }
        for(int num: map.keySet()){
            if(map.get(num)>0){
                map.put(num, map.get(num)-1);
                current.add(num);
                permutation(nums, map, current, result);
                current.remove(current.size()-1);
                map.put(num, map.get(num)+1);
            }
        }
    }
}