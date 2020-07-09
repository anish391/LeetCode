class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low = i+1; int high = nums.length-1;
                int sum = -nums[i];
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        while(low<high && nums[low]==nums[low+1])
                            low++;
                        while(low<high && nums[high]==nums[high-1])
                            high--;
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<sum){
                        low++;
                    }
                    else{
                        high--;
                    }
                }
            }
            
        }
        return result;
        
    }
}