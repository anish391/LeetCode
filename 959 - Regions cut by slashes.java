class Solution {
    // Convert the problem to a bigger grid where each cell of bigger grid is 3 times original grid.
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] square = new boolean[n*3][n*3];
        int regions = 0;
        for(int i=0;i<n;i++){
            String row = grid[i];
            for(int j=0;j<row.length();j++){
                char slash = row.charAt(j);
                if(slash=='/'){
                    square[i*3][j*3+2] = square[i*3+1][j*3+1] = square[i*3+2][j*3] = true;
                }
                else if(slash=='\\'){
                    square[i*3][j*3] = square[i*3+1][j*3+1] = square[i*3+2][j*3+2] = true;
                }
            }
        }
        for(int i=0;i<square.length;i++){
            for(int j=0;j<square[0].length;j++){
                if(!square[i][j]){
                    dfs(square, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }
    
    public void dfs(boolean[][] square, int r, int c){
        if(r<0 || c<0 || r>=square.length || c>=square[0].length || square[r][c])
            return;
        square[r][c] = true;
        dfs(square, r-1, c);
        dfs(square, r, c+1);
        dfs(square, r+1, c);
        dfs(square, r, c-1);
    }
}

// Union Find method 

class Solution {
    
    private class UnionFind{
        int count;
        int[] parent;
        public UnionFind(boolean[][] square){
            this.count = 0;
            this.parent = new int[square.length*square[0].length];
            int m = square.length, n = square[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int id = i*n+j;
                    if(!square[i][j]){
                        this.parent[id] = id;
                        this.count++;
                    }
                    else{
                        this.parent[id] = -1;
                    }
                }
            }
        }
        
        private int find(int node){
            while(node!=parent[node]){
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
    
    // Convert the problem to a bigger grid where each cell of bigger grid is 3 times original grid.
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] square = new boolean[n*3][n*3];
        int regions = 0;
        for(int i=0;i<n;i++){
            String row = grid[i];
            for(int j=0;j<row.length();j++){
                char slash = row.charAt(j);
                if(slash=='/'){
                    square[i*3][j*3+2] = square[i*3+1][j*3+1] = square[i*3+2][j*3] = true;
                }
                else if(slash=='\\'){
                    square[i*3][j*3] = square[i*3+1][j*3+1] = square[i*3+2][j*3+2] = true;
                }
            }
        }
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        UnionFind uf = new UnionFind(square);
        int m = square.length;
        for(int r=0;r<m;r++){
            for(int c=0;c<m;c++){
                if(!square[r][c]){
                    for(int[] direction: directions){
                        int dr = r + direction[0];
                        int dc = c + direction[1];
                        if(dr>=0 && dc>=0 && dr<square.length && dc<square[0].length && !square[dr][dc]){
                            int node1 = r*m+c;
                            int node2 = dr*m+dc;
                            uf.union(node1, node2);
                        }
                    }    
                }
            }
        }
        return uf.count;
    }
}

