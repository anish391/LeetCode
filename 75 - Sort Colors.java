class Solution {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                red++;
            else if(nums[i]==1)
                white++;
            else if(nums[i]==2)
                blue++;
        }
        int i=0;
        while(red>0 && i<nums.length){
            red--;
            nums[i++] = 0;
        }
        while(white>0 && i<nums.length){
            white--;
            nums[i++] = 1;
        }
        while(blue>0 && i<nums.length){
            blue--;
            nums[i++] = 2;
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[blue++] = 2;
                nums[white++] = 1;
                nums[red++] = 0;
            } else if(nums[i]==1) {
                nums[blue++] = 2;
                nums[white++] = 1;
            } else{
                nums[blue++] = 2;
            }
        }
    }
}