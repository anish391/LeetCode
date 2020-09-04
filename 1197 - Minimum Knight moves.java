class Solution {
    
    private int[][] directions = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    
    public int minKnightMoves(int x, int y) {
        // Since all moves are symmetric, we consider only first quadrant.
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> queue = new LinkedList();
        Set<String> visited = new HashSet();
        
        queue.offer(new int[]{0,0});
        visited.add("0:0");
        
        int result = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                if(currentX==x && currentY==y)
                    return result;
                for(int[] direction: directions){
                    int newX = currentX+direction[0];
                    int newY = currentY+direction[1];
                    if(!visited.contains(newX+":"+newY) && newX>=-1 && newY>=-1){
                        visited.add(newX+":"+newY);
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            result++;
        }
        return -1;
    }
}


// DP solution

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Integer> memo = new HashMap();
        return dp(x, y, memo);
    }
    
    public int dp(int x, int y, Map<String, Integer> memo){
        String cell = x+":"+y;
        if(memo.containsKey(cell))
            return memo.get(cell);
        if(x+y==0)
            return 0;
        if(x+y==2)
            return 2;
        int minimumMoves = Math.min(dp(Math.abs(x-1), Math.abs(y-2), memo),
                                    dp(Math.abs(x-2), Math.abs(y-1),memo))+1;
        memo.put(cell, minimumMoves);
        return minimumMoves;
    }
}