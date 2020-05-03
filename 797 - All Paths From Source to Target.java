class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList();
        List<Integer> path = new ArrayList();
        path.add(0);
        helper(graph,0,path);
        return result;
    }
    
    public void helper(int[][] graph, int node, List<Integer> path){
        if(node==graph.length-1){
            result.add(new ArrayList(path));
            return;
        }
        for(int nei:graph[node]){
            path.add(nei);
            helper(graph, nei, path);
            path.remove(path.size()-1);
        }
    }
}