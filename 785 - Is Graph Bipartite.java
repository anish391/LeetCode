// DFS Graph coloring
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // 0: Uncolored, 1: Blue, -1: Red
        int[] colors = new int[n];
        for(int i=0;i<n;i++){
            if(colors[i]==0 && !isValidColor(graph, colors, 1, i)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidColor(int[][] graph, int[] colors, int color, int node){
        if(colors[node]!=0){
            return colors[node]==color;
        }
        colors[node] = color;
        for(int nextNode: graph[node]){
            if(!isValidColor(graph, colors, -color, nextNode))
                return false;
        }
        return true;
    }
}

// BFS Graph coloring
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0;i<n;i++){
            if(colors[i]!=0)
                continue;
            Queue<Integer> queue = new LinkedList();
            queue.offer(i);
            colors[i] = 1;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int nextNode: graph[node]){
                    if(colors[nextNode]==0){
                        colors[nextNode] = -colors[node];
                        queue.offer(nextNode);
                    }
                    else if(colors[node] != -colors[nextNode]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}