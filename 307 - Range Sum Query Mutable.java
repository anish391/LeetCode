class NumArray {
    private int[] cache;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        cache = new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
            cache[i+1] = cache[i]+nums[i];
    }
    
    public void update(int i, int val) {
        this.nums[i] = val;
        for(int j=i;j<nums.length;j++)
            cache[j+1] = cache[j] + nums[j];
    }
    
    public int sumRange(int i, int j) {
        return cache[j+1] - cache[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */