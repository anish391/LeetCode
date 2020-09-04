// DFS solution.
class Solution {
    private int minCost;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        minCost = Integer.MAX_VALUE;
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.putIfAbsent(u, new HashMap());
            graph.putIfAbsent(v, new HashMap());
            Map<Integer, Integer> edge = graph.get(u);
            edge.put(v, wt);
            graph.put(u, edge);
        }
        //boolean[] visited = new boolean[graph.size()];
        dfs(src, dst, K+1, 0, graph);
        return minCost==Integer.MAX_VALUE?-1:minCost;
    }
    
    public void dfs(int src, int dst, int K, int cost, Map<Integer, Map<Integer, Integer>> graph){
        if(K<0){
            return;
        }
        if(src==dst){
            minCost = cost;
            return;
        }
        Map<Integer, Integer> neighbors = graph.get(src);
        for(Map.Entry<Integer, Integer> neighbor: neighbors.entrySet()){
            int v = neighbor.getKey();
            int wt = neighbor.getValue();
            if(cost+wt>minCost)
                continue;
            dfs(v, dst, K-1, cost+wt, graph);
        }
    }
}

// BFS 

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.putIfAbsent(u, new HashMap());
            graph.putIfAbsent(v, new HashMap());
            Map<Integer, Integer> edge = graph.get(u);
            edge.put(v, wt);
            graph.put(u, edge);
        }
        int minCost = bfs(src, dst, K+1, graph);
        return minCost==Integer.MAX_VALUE?-1:minCost;
    }
    
    public int bfs(int src, int dst, int K, Map<Integer, Map<Integer, Integer>> graph){
        int minCost = Integer.MAX_VALUE;
        int steps = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{src, 0});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] node = queue.poll();
                int u = node[0];
                int costSoFar = node[1];
                if(u==dst)
                    minCost = Math.min(minCost, costSoFar);
                Map<Integer, Integer> neighbors = graph.get(u);
                if(neighbors==null)
                    continue;
                for(Map.Entry<Integer, Integer> neighbor: neighbors.entrySet()){
                    int v = neighbor.getKey();
                    int wt = neighbor.getValue();
                    if(costSoFar + wt > minCost)
                        continue;
                    queue.offer(new int[] {v, costSoFar+wt});
                }
            }
            steps++;
            if(steps>K)
                break;
        }
        return minCost==Integer.MAX_VALUE?-1:minCost;
    }
}

// Dijsktra's Algorithm

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.putIfAbsent(u, new HashMap());
            Map<Integer, Integer> edge = graph.get(u);
            edge.put(v, wt);
            graph.put(u, edge);
        }
        int minCost = dijsktra(src, dst, K, graph);
        return minCost==Integer.MAX_VALUE?-1:minCost;
    }
    
    public int dijsktra(int src, int dst, int K, Map<Integer, Map<Integer, Integer>> graph){
        int minCost = Integer.MAX_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] u, int[] v){
                return Integer.compare(u[0], v[0]);
            }
        });
        queue.offer(new int[]{0, src, K+1});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int costSoFar = node[0];
            int u = node[1];
            int steps = node[2];
            if(u==dst)
                return costSoFar;
            if(steps>0){
                Map<Integer, Integer> neighbors = graph.get(u);
                if(neighbors==null)
                    continue;
                for(Map.Entry<Integer, Integer> neighbor: neighbors.entrySet()){
                    int v = neighbor.getKey();
                    int wt = neighbor.getValue();
                    queue.offer(new int[]{costSoFar+wt, v, steps-1});
                }
            }
        }
        return -1;
    }
}