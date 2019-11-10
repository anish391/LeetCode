class Solution {
    List<List<Integer>> result = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0, nums.length-1);
        return result;
    }
    
    public void permute(int[] nums, int l, int r){
        //List<Integer> list = new ArrayList();
        if(l==r){
            List<Integer> list = new ArrayList();
            for(int i:nums)
                list.add(i);
            result.add(list);
        }
        for(int i=l;i<=r;i++){
            nums = swap(nums, l, i);
            permute(nums, l+1, r);
            nums = swap(nums, l, i);
        }
    }
    
    public int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}