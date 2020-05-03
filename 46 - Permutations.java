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

class Solution {
    private int n;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        n = nums.length;
        permute(result, new ArrayList<Integer>(), nums, visited);
        return result;
    }
    
    public void permute(List<List<Integer>> result, List<Integer> list,int[] nums, boolean[] visited){
        if(list.size()==n){
            result.add(new ArrayList(list));
        }
        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            permute(result, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

}