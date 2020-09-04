class Solution {
    private int n,m;
    
    public int numIslands(char[][] grid) {    
        int count = 0;
        n = grid.length;
        if(n==0)
            return 0;
        m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!='1')
            return;
        grid[i][j] = '0';
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

// Union Find

class Solution {
    
    private class UnionFind{
        
        int[] parent;
        int count;
        
        public UnionFind(char[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m*n];
            count = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int id = i*n+j;
                    if(grid[i][j]=='1'){
                        this.parent[id] = id;
                        this.count++;
                    }
                    else{
                        this.parent[id] = -1;
                    }
                }
            }
        }
        
        public int find(int node){
            while(node!=this.parent[node]){
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        
        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1==root2)
                return;
            this.parent[root1] = root2;
            this.count--;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int islands = 0;
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        UnionFind uf = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]=='1'){
                    for(int[] direction: directions){
                        int dr = r + direction[0];
                        int dc = c + direction[1];
                        if(dr>=0 && dc>=0 && dr<m && dc<n && grid[dr][dc]=='1'){
                            int node1 = r*n+c;
                            int node2 = dr*n+dc;
                            uf.union(node1, node2);
                        }
                    }   
                }
            }
        }
        return uf.count;
    }
}