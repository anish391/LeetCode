class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int friendCircles = 0;
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    graph.putIfAbsent(i, new ArrayList<Integer>());
                    if(i!=j)
                        graph.get(i).add(j);
                }
            }
        }
        for(int i=0;i<M.length;i++){
            if(!visited[i]){
                dfs(i, visited, graph);
                friendCircles++;
            }
        }
        return friendCircles;
    }
    
    public void dfs(int root, boolean[] visited, Map<Integer, List<Integer>> graph){
        for(int neighbor: graph.get(root)){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor, visited, graph);
            }
        }
    }
}

public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}