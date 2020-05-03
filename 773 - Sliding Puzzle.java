class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                sb.append(board[i][j]);
            }
        }
        int[][] dirs = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet(); 
        queue.offer(sb.toString());
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String current = queue.poll();
                if(target.equals(current))
                    return moves;
                int zeroLocation = current.indexOf('0');
                for(int index: dirs[zeroLocation]){
                    String nextMove = swap(current, zeroLocation, index);
                    if(visited.contains(nextMove))
                        continue;
                    queue.add(nextMove);
                    visited.add(nextMove);
                }
            }
            moves++;
        }
        return -1;
    }
    
    public String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
        return sb.toString();
    }
}