class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[] directions = {1,0,-1};
        boolean[][] queenCells = new boolean[8][8];
        List<List<Integer>> result = new ArrayList();
        for(int[] queen: queens)
            queenCells[queen[0]][queen[1]] = true;
        for(int dx: directions){
            for(int dy: directions){
                if(dx==0 && dy==0)
                    continue;
                int x = king[0], y=king[1];
                // Start from king and break if end of board or queen found.
                while(x+dx>=0 && x+dx<8 && y+dy>=0 && y+dy<8){
                    x += dx;
                    y += dy;
                    if(queenCells[x][y]){
                        result.add(Arrays.asList(x,y));
                        break;
                    }
                }
            }
        }
        return result;
    }
}