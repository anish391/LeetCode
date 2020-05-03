class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList();
        int count = 0;
        int index = 0;
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
        for(int[] prerequisite: prerequisites){
            graph[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(index>numCourses)
                break;
            order[index++] = node;
            for(int i=0;i<graph[node].size();i++){
                int neighbor = graph[node].get(i);
                indegree[neighbor]--;
                if(indegree[neighbor]==0)
                    queue.offer(neighbor);
            }
            count++;
        }
        if(index>numCourses || count!=numCourses)
            return new int[0];
        else
            return order;
    }
}