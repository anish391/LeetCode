class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stonePositions = {a,b,c};
        int[] minMaxMoves = new int[2];
        Arrays.sort(stonePositions);
        int xyDistance = stonePositions[1]-stonePositions[0]-1;
        int yzDistance = stonePositions[2]-stonePositions[1]-1;
        if(xyDistance>1 && yzDistance>1)
            minMaxMoves[0] = 2;
        else if(xyDistance>=1 || yzDistance>=1)
            minMaxMoves[0] = 1;
        minMaxMoves[1] = xyDistance+yzDistance;
        return minMaxMoves;
    }
}