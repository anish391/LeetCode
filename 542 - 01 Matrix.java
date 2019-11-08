class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // int[][] solution = new int[matrix.length][matrix[0].length];
        Queue<int []> queue = new LinkedList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0)
                    queue.add(new int[] {i,j});
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] d: dir){
                int row = cell[0] + d[0];
                int col = cell[1] + d[1];
                if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length || matrix[row][col] <= matrix[cell[0]][cell[1]]+1)
                    continue;
                queue.add(new int[] {row,col});
                matrix[row][col] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
    
}