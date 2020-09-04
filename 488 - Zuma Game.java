class Solution {
    int MAXCOUNT = 6;
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for(int i=0;i<hand.length();i++)
            handCount[hand.charAt(i)-'A']++;
        int result = dfs(board+"#", handCount);
        return result==MAXCOUNT?-1:result;
    }
    
    public int dfs(String board, int[] handCount){
        board = removeConsecutive(board);
        if(board.equals("#"))
            return 0;
        int result = MAXCOUNT, need=0;
        for(int i=0, j=0;j<board.length();j++){
            if(board.charAt(i)==board.charAt(j))
                continue;
            need = 3-(j-i);
            if(handCount[board.charAt(i)-'A']-need>=0){
                handCount[board.charAt(i)-'A']-=need;
                result = Math.min(result, need+dfs(board.substring(0,i)+board.substring(j), handCount));
                handCount[board.charAt(i)-'A']+=need;
            }
            i=j;
        }
        return result;
    }
    
    public String removeConsecutive(String board){
        for(int i=0, j=0;j<board.length();j++){
            if(board.charAt(i)==board.charAt(j))
                continue;
            if(j-i>=3)
                return removeConsecutive(board.substring(0,i)+board.substring(j));
            else
                i=j;
        }
        return board;
    }
}


// Solved with test case

class Solution {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for(int i=0;i<hand.length();i++)
            handCount[hand.charAt(i)-'A']++;
        return helper(board, handCount);
    }
    
    public int helper(String board, int[] handCount){
        if(board.equals(""))
            return 0;
        int result = 2*board.length()+1;
        for(int i=0;i<board.length();){
            int j=i;
            while(i<board.length() && board.charAt(i)==board.charAt(j))
                i++;
            // If there are more than three balls of same color in a row, this number will be negative.
            int needed = 3-(i-j);
            if(handCount[board.charAt(j)-'A']-needed>=0){
                int usedBalls = needed<=0?0:needed;
                handCount[board.charAt(j)-'A']-=usedBalls;
                int temp = helper(board.substring(0,j)+board.substring(i), handCount);
                if(temp>=0)
                    result = Math.min(result, usedBalls+temp);
                handCount[board.charAt(j)-'A']+=usedBalls;
            }
        }
        return result==2*board.length()+1? -1:result;
    }
}