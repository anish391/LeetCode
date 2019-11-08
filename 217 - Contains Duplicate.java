class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i: nums)
            set.add(i);
        //System.out.print(set);
        return set.size()==nums.length?false:true;
    }
}