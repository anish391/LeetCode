class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return new ArrayList();
        int r=0, c=0, row=matrix.length-1, col = matrix[0].length-1;
        List<Integer> list = new ArrayList();
        while(r<=row && c<=col){
            for(int i=c;i<=col;i++)
                list.add(matrix[r][i]);
            r++;
            for(int i=r;i<=row;i++)
                list.add(matrix[i][col]);
            col--;
            if(r<=row){
                for(int i=col;i>=c;i--)
                    list.add(matrix[row][i]);
                row--;    
            }
            if(c<=col){
                for(int i=row;i>=r;i--)
                    list.add(matrix[i][c]);
                c++;    
            }
        }
        return list;
    }
}