//HashMap solution. Slow for stupid reasons.

class Solution {
    private int time = 0; // current time of discovery
    Map<Integer, List<Integer>> graph; // node -> neighbors
    boolean[] visited;
    List<List<Integer>> out = new ArrayList();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        graph = new HashMap(n,(float)1.0);
        for (List<Integer> conn : connections) {
            int n1 = conn.get(0);
            int n2 = conn.get(1);
            graph.putIfAbsent(n1, new ArrayList<>());
            graph.putIfAbsent(n2, new ArrayList<>());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int[] disc = new int[n]; // discovery time of each node
        int[] low = new int[n]; // earliest discovered node reachable from this node in DFS
         // whether this node has been visited in DFS
        //List<List<Integer>> out = new ArrayList<>();
        visited = new boolean[n];
        dfs(0, -1, disc, low); // arbitrarily pick a node to start DFS

        return out;
    }

    // root = current node under consideration
    // parent = parent of current node
    private void dfs(int root, int parent, int[] disc, int[] low) {
        visited[root] = true;
        disc[root] = time++;
        low[root] = disc[root]; // we don't have to initialize low[] to inf because of this line

        List<Integer> neighbors = graph.get(root);
        if (neighbors == null) {
            return;
        }

        for (Integer nei : neighbors) {
            if (nei == parent) {
                continue;
            }

            if (!visited[nei]) {
                dfs(nei, root, disc, low);
                low[root] = Math.min(low[root], low[nei]);
                if (disc[root] < low[nei]) {
                    out.add(Arrays.asList(root, nei));
                }
            } else {
                low[root] = Math.min(low[root], disc[nei]);
            }
        }
    }
}

// List Solution

class Solution {
    private int time = 0;
    private int[] discovered;
    private int[] low;
    private boolean[] visited;
    private List<List<Integer>> result;
    private List<Integer>[] graph;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        result = new ArrayList(n);
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }
        for(List<Integer> connection: connections){
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        discovered = new int[n];
        low = new int[n];
        visited = new boolean[n];
        dfs(0,-1);
        return result;
    }
    
    public void dfs(int root, int parent){
        time++;
        discovered[root] = time;
        low[root] = time;
        visited[root] = true;
        List<Integer> neighbors = graph[root];
        if(neighbors==null)
            return;
        for(int neighbor: neighbors){
            if(neighbor==parent)
                continue;
            if(!visited[neighbor]){
                dfs(neighbor, root);
                low[root] = Math.min(low[root],low[neighbor]);
                if(low[neighbor]>discovered[root])
                    result.add(Arrays.asList(root,neighbor));
            }
            else
                low[root] = Math.min(low[root],low[neighbor]);
        }
        
    }
}