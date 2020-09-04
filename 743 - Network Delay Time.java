class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        boolean[] visited = new boolean[N+1];
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            graph.putIfAbsent(u, new HashMap());
            Map<Integer, Integer> edge = graph.get(u);
            edge.put(v, wt);
        }
        //System.out.println(graph);
        return dijsktra(graph, visited, K, N);
    }
    
    public int dijsktra(Map<Integer, Map<Integer, Integer>> graph, boolean[] visited, int src, int N){
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] u, int[] v){
                return Integer.compare(u[0], v[0]);
            }
        });
        int time = 0;
        queue.offer(new int[]{0, src});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int timeSoFar = node[0];
            int u = node[1];
            if(visited[u])
                continue;
            visited[u] = true;
            N--;
            time = timeSoFar;
            Map<Integer, Integer> neighbors = graph.get(u);
            if(neighbors==null)
                continue;
            for(Map.Entry<Integer, Integer> neighbor: neighbors.entrySet()){
                int v = neighbor.getKey();
                int wt = neighbor.getValue();
                queue.offer(new int[]{timeSoFar+wt, v});
            }
        }
        return N==0?time:-1;
    }
}