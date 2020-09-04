// Recursive Solution
class Solution {
    public boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, piles.length-1, true)>0;
    }
    
    public int stoneGame(int[] piles, int startIndex, int endIndex, boolean alexTurn){
        if(startIndex>endIndex){
            return 0;
        }
        // For alex's turn, we add the value of stones and for Lee's turn we subtract value of stones.
        if(alexTurn){
            int pickStart = stoneGame(piles, startIndex+1, endIndex, !alexTurn)+piles[startIndex];
            int pickEnd = stoneGame(piles, startIndex, endIndex-1, !alexTurn)+piles[endIndex];
            return Math.max(pickStart, pickEnd);
        }
        else{
            int pickStart = stoneGame(piles, startIndex+1, endIndex, !alexTurn)-piles[startIndex];
            int pickEnd = stoneGame(piles, startIndex, endIndex-1, !alexTurn)-piles[endIndex];
            return Math.min(pickStart, pickEnd);
        }
    }
}

// TopDown solution

class Solution {
    public boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, piles.length-1, true, new int[piles.length][piles.length])>0;
    }
    
    public int stoneGame(int[] piles, int startIndex, int endIndex, boolean alexTurn, int[][] memo){
        if(startIndex>endIndex){
            return 0;
        }
        if(memo[startIndex][endIndex]>0)
            return memo[startIndex][endIndex];
        // For alex's turn, we add the value of stones and for Lee's turn we subtract value of stones.
        if(alexTurn){
            int pickStart = stoneGame(piles, startIndex+1, endIndex, !alexTurn, memo)+piles[startIndex];
            int pickEnd = stoneGame(piles, startIndex, endIndex-1, !alexTurn, memo)+piles[endIndex];
            memo[startIndex][endIndex] = Math.max(pickStart, pickEnd);
            return memo[startIndex][endIndex];
        }
        else{
            int pickStart = stoneGame(piles, startIndex+1, endIndex, !alexTurn, memo)-piles[startIndex];
            int pickEnd = stoneGame(piles, startIndex, endIndex-1, !alexTurn, memo)-piles[endIndex];
            memo[startIndex][endIndex] = Math.min(pickStart, pickEnd);
            return memo[startIndex][endIndex];
        }
    }
}

// Bottom up solution

