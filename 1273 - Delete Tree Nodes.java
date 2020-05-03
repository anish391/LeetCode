class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<nodes;i++){
            graph.add(new ArrayList());
        }
        for(int i=0;i<nodes;i++){
            if(parent[i]!=-1){
                graph.get(parent[i]).add(i);
            }
        }
        return dfs(graph, value, 0)[1];
    }
    
    public int[] dfs(List<List<Integer>> graph, int[] value, int root){
        int sum = value[root];
        int nodeCount = 1;
        for(int child: graph.get(root)){
            int[] temp = dfs(graph, value, child);
            sum+=temp[0];
            nodeCount+=temp[1];
        }
        if(sum==0)
            nodeCount=0;
        return new int[]{sum, nodeCount};
    }
}