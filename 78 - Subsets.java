class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        subsets(nums, 0, result, new LinkedList<Integer>());
        return result;
    }
    
    public void subsets(int[] nums, int i, List<List<Integer>> results, List<Integer> path){
        if(i==nums.length){
            results.add(path);
            return;
        }
        List<Integer> pathWithCurrent = new LinkedList<Integer>(path);
        pathWithCurrent.add(nums[i]);
        subsets(nums,i+1,results,path);
        subsets(nums,i+1,results,pathWithCurrent);
    }
}

