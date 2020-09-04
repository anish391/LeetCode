class Solution {
    int time = 0;
    int apples;
    Map<Integer, List<Integer>> graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        apples = 0;
        for(boolean apple: hasApple){
            apples += apple?1:0;
        }
        graph = new HashMap();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList());
            graph.putIfAbsent(v, new ArrayList());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, hasApple, new boolean[hasApple.size()]);
        return time;
    }
    
    public boolean dfs(int root, List<Boolean> hasApple, boolean[] visited){
        if(visited[root])
            return false;
        boolean foundApple = false;
        if(hasApple.get(root)){
            foundApple = true;
            apples--;
        }
        visited[root] = true;
        for(int child: graph.get(root)){
            if(apples>0){
                boolean appleWithChild = dfs(child, hasApple, visited);
                if(appleWithChild){
                    time+=2; 
                }
                foundApple = foundApple || appleWithChild;
            }
        }
        return foundApple;
    }
}