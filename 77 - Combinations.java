class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        combine(result, new ArrayList<Integer>(),1, n, k);
        return result;
    }
    
    public void combine(List<List<Integer>> result, List<Integer> list, int start, int n, int k){
        if(k==0){
            //System.out.println(list);
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n-k+1;i++){
            list.add(i);
            combine(result, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}