class Solution {
    private int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        n = candidates.length;
        combinationSum(result, new ArrayList<Integer>(), candidates, target,0);
        return result;
    }
    
    public void combinationSum(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start){
        if(target==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start;i<n;i++){
            if(target-candidates[i]>=0){
                list.add(candidates[i]);
                combinationSum(result, list, candidates, target-candidates[i],i);
                list.remove(list.size()-1);
            }
        }
    }
}