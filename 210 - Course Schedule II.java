class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        List<Integer> courseOrder = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        int[] indegree = new int[numCourses];
        int finishedCourses = 0;
        for(int i=0;i<graph.length;i++)
            graph[i] = new ArrayList();
        for(int[] prerequisite: prerequisites){
            int courseToTake = prerequisite[0];
            int preCourse = prerequisite[1];
            graph[preCourse].add(courseToTake);
            indegree[courseToTake]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            courseOrder.add(course);
            finishedCourses++;
            for(int nextCourse: graph[course]){
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0)
                    queue.offer(nextCourse);
            }
        }
        if(finishedCourses!=numCourses)
            return new int[0];
        int[] result = new int[numCourses];
        for(int i=0;i<courseOrder.size();i++){
            result[i] = courseOrder.get(i);
        }
        return result;
    }
}