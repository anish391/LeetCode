class Solution {
    // Start from the leaf nodes and keep deleting leaves until you cannot.
    // Remaining leaves are the answer. 
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList();
        if(n==1){
            result.add(0);
            return result;
        }
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<graph.length;i++)
            graph[i] = new ArrayList();
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for(int i=0;i<degree.length;i++){
            if(degree[i]==1)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for(int i=0;i<size;i++){
                int leaf = queue.poll();
                list.add(leaf);
                for(int parent: graph[leaf]){
                    degree[parent]--;
                    if(degree[parent]==1)
                        queue.offer(parent);
                }
            }
            result = list;
        }
        return result;
    }
}