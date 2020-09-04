class Solution {
    public String tictactoe(int[][] moves) {
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int diagonal = 0;
        int antiDiagonal = 0;
        boolean isX = true;
        for(int[] move: moves){
            int r = move[0];
            int c = move[1];
            int player = isX?1:-1;
            rowSum[r] += player;
            colSum[c] += player;
            isX = !isX;
            if(r==c)
                diagonal +=player;
            if(r+c==2)
                antiDiagonal +=player;
        }
        // Have to flip isX to get player who made latest previous move.
        for(int i=0;i<rowSum.length;i++)
            if(Math.abs(rowSum[i]) == 3)
                return !isX?"A":"B";
        for(int i=0;i<colSum.length;i++)
            if(Math.abs(colSum[i]) == 3)
                return !isX?"A":"B";
        if(Math.abs(diagonal) == 3)
            return !isX?"A":"B";
        if(Math.abs(antiDiagonal) == 3)
            return !isX?"A":"B";
        return moves.length==9?"Draw":"Pending" 
    }
    
}