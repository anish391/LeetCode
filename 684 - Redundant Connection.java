class Solution {
    private class UnionFind{
        int[] parent;
        
        public UnionFind(int n){
            parent = new int[n+1];
            for(int i=0;i<parent.length;i++){
                parent[i] = i;
            }
        }
        
        private int find(int node){
            while(node!=parent[node]){
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        
        public boolean union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1==root2)
                return false;
            parent[root1] = root2;
            return true;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        if(edges==null || edges.length==0 || edges[0].length==0)
            return null;
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            if(!uf.union(node1, node2))
                return new int[]{node1, node2};
        }
        return null;
    }
}