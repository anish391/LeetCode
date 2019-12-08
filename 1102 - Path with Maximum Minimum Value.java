class Solution {
    public int maximumMinimumPath(int[][] A) {
        int minValue = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[A.length][A[0].length];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        pq.offer(new Cell(0,0,A[0][0]));
        while(!pq.isEmpty()){
            Cell cell = pq.poll();
            if(cell.x == A.length-1 && cell.y == A[0].length-1){
                return cell.val;
            }
            for(int[] dir: dirs){
                int x = cell.x + dir[0];
                int y = cell.y + dir[1];
                if(x>-1 && y>-1 && x<A.length && y<A[0].length && !visited[x][y]){
                    visited[x][y] = true;
                    pq.offer(new Cell(x,y,Math.min(A[x][y],cell.val)));
                }
            }
        }
        return -1;
        
    }
    
    
    private class Cell{
        private int x;
        private int y;
        private int val;
        public Cell(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}