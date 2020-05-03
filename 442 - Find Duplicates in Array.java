class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int i: nums){
            if(set.contains(i))
                result.add(i);
            set.add(i);
        }
        return result;
    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0)
                result.add(Math.abs(nums[i]));
            nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        return result;
    }
}