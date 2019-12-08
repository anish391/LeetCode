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



class Solution { 
public List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    //Find size of bits
    int totalNumber = 1 << S.length;
    List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
    for (int i=0; i<totalNumber; i++) {
        List<Integer> set = new LinkedList<Integer>();
        for (int j=0; j<S.length; j++) {
            if ((i & (1<<j)) != 0) {
                set.add(S[j]);
            }
        }
        collection.add(set);
    }
    return collection;
}
}