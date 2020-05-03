class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i=0;i<graph.length;i++)
            graph[i] = new ArrayList<Integer>();
        for(int[] prerequisite: prerequisites){
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for(int i=0;i<numCourses;i++)
            if(dfs(graph, visited, i))
                return false;
        return true;
    }
    
    public boolean dfs(List<Integer>[] graph, boolean[] visited, int node){
        if(visited[node])
            return true;
        visited[node] = true;
        for(int i=0;i<graph[node].size();i++){
            int neighbor = graph[node].get(i);
            if(dfs(graph, visited, neighbor))
                return true;
        }
        visited[node] = false;
        return false;
    } 
}


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
        for(int[] prerequisite: prerequisites){
            indegree[prerequisite[1]]++;
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for(int i=0;i<indegree.length;i++)
            if(indegree[i]==0)
                queue.offer(i);
        int nodeCount=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            nodeCount++;
            for(int i=0;i<graph[node].size();i++){
                int neighbor = graph[node].get(i);
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return nodeCount==numCourses;
    }
}