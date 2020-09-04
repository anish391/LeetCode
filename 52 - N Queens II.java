class Solution {
    private int result;
    public int totalNQueens(int n) {
        result = 0;
        solveNQueens(0, n, new ArrayList());
        return result;
    }
    
    public void solveNQueens(int row, int n, List<Integer> colPlacements){
        if(row==n){
            result++;
        }
        else{
            for(int col=0;col<n;col++){
                colPlacements.add(col);
                if(isValidPlacement(row, colPlacements))
                    solveNQueens(row+1, n, colPlacements);
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }
    
    public boolean isValidPlacement(int row, List<Integer> colPlacement){
        for(int i=0;i<row;i++){
            int absoluteColDistance = Math.abs(colPlacement.get(i)-colPlacement.get(row));
            int absoluteRowDistance = Math.abs(i-row);
            if(absoluteColDistance==0 || absoluteColDistance==absoluteRowDistance){
                return false;
            }
        }
        return true;
    }
}