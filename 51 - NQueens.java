class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();
        if(n==0)
            return result;
        boolean[][] grid = new boolean[n][n];
        solveNQueens(0, n, new ArrayList(), result);
        return result;
    }
    
    public void solveNQueens(int row, int n, List<Integer> colPlacements, List<List<String>> result){
        if(row==n){
            List<String> convertedBoard = convertBoard(n, colPlacements);
            result.add(convertedBoard);
        }
        else{
            for(int col=0;col<n;col++){
                colPlacements.add(col);
                if(isValidPlacement(row, colPlacements)){
                    solveNQueens(row+1, n, colPlacements, result);
                }
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }
    
    public boolean isValidPlacement(int row, List<Integer> colPlacements){
        for(int i=0;i<row;i++){
            int absoluteColDistance = Math.abs(colPlacements.get(i) - colPlacements.get(row));
            int absoluteRowDistance = Math.abs(i-row);
            if(absoluteColDistance==0 || absoluteColDistance==absoluteRowDistance)
                return false;
        }
        return true;
    }
    
    public List<String> convertBoard(int n, List<Integer> colPlacements){
        List<String> board = new ArrayList();
        for(int row=0;row<n;row++){
            StringBuilder sb = new StringBuilder();
            for(int col=0;col<n;col++){
                if(colPlacements.get(row)==col)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            board.add(sb.toString());
        }
        return board;
    }
}