class Solution {
    public int[][] generateMatrix(int n) {
        int r=0,c=0,row=n-1,col=n-1;
        int temp = 1;
        int[][] result = new int[n][n];
        while(r<=row && c<=col){
            for(int i=c;i<=col;i++)
                result[r][i] = temp++;
            r++;
            for(int i=r;i<=row;i++)
                result[i][col] = temp++;
            col--;
            if(r<=row){
                for(int i=col;i>=c;i--)
                    result[row][i] = temp++;
                row--;
            }
            if(c<=col){
                for(int i=row;i>=r;i--)
                    result[i][c] = temp++;
                c++;
            }
        }
        return result;
    }
}