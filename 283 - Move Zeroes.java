class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int anchor = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[anchor] = nums[i];
                anchor++;
            }
        }
        while(anchor<nums.length){
            nums[anchor++] = 0;
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums, i, index);
                index++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}