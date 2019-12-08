class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0)
            return;
        List<Pair> list = new ArrayList();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0)
                    list.add(new Pair(i,j));
            }
        }
        for(Pair p: list){
            int x = p.x;
            int y = p.y;
            setRow(matrix,x);
            setColumn(matrix,y);
        }
    }
    
    private void setRow(int[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++)
            matrix[row][i] = 0;
    }
    
    private void setColumn(int[][] matrix, int col){
        for(int i=0;i<matrix.length;i++)
            matrix[i][col] = 0;
    }
    
    private class Pair{
        private int x;
        private int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}