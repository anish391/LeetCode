class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> graph = new HashMap();
        Set<Integer> visited = new HashSet();
        int numStones = stones.length;
        int numIslands = 0;
        for(int i=0;i<numStones;i++){
            int row = stones[i][0];
            int col = ~stones[i][1];
            graph.putIfAbsent(row, new ArrayList());
            graph.putIfAbsent(col, new ArrayList());
            graph.get(row).add(col);
            graph.get(col).add(row);
        }
        for(int i=0;i<numStones;i++){
            for(int j=0;j<2;j++){
                int position = j==0?stones[i][0]:~stones[i][1];
                if(!visited.contains(position)){
                    dfs(graph, visited, position);
                    numIslands++;
                }
            }
        }
        return numStones-numIslands;
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int position){
        if(visited.contains(position))
            return;
        visited.add(position);
        for(int neighbor: graph.get(position)){
            dfs(graph, visited, neighbor);
        }
    }
}