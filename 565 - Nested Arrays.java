class Solution {
    private int arrayLength;
    public int arrayNesting(int[] nums) {
        arrayLength = nums.length;
        int maxSize = Integer.MIN_VALUE;
        boolean[] visited = new boolean[arrayLength];
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                //set = new HashSet();
                int start = nums[i];
                int count = 0;
                do{
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }while(start!=nums[i]);
                maxSize = Math.max(count, maxSize);    
            }
            
        }
        return maxSize;
    }
}

class Solution {
    private int arrayLength;
    public int arrayNesting(int[] nums) {
        arrayLength = nums.length;
        int maxSize = Integer.MIN_VALUE;
        //boolean[] visited = new boolean[arrayLength];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=Integer.MAX_VALUE){
                //set = new HashSet();
                int start = nums[i];
                int count = 0;
                while(nums[start]!=Integer.MAX_VALUE){
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                maxSize = Math.max(count, maxSize);    
            }
            
        }
        return maxSize;
    }
}