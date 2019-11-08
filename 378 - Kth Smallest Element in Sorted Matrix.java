class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length-1][matrix[0].length-1];
        while(low<high){
            int mid = low + (high-low)/2;
            int count = 0, j = matrix[0].length-1;
            for(int i=0;i<matrix.length;i++){
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
				//Number of elements less than K
                count+=j+1;
            }
            if(count<k)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int i=0;i<n;i++)
            pq.offer(new Tuple(0,i,matrix[0][i]));
        for(int i=0;i<k-1;i++){
            Tuple t = pq.poll();
            if(t.x==n-1)
                continue;
            pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return pq.peek().val;
    }
    
    class Tuple implements Comparable<Tuple>{
        int x,y,val;
        Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }
}