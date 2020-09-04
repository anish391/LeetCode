class Solution {
    public int minFallingPathSum(int[][] arr) {
        for(int i=1;i<arr.length;i++){
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int num: arr[i-1])
                pq.add(num);
            int firstMin = pq.poll();
            int secondMin = pq.poll();
            for(int j=0;j<arr[0].length;j++){
                if(arr[i-1][j]==firstMin)
                    arr[i][j] +=secondMin;
                else 
                    arr[i][j] +=firstMin;
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<arr[0].length;i++)
            minSum = Math.min(minSum, arr[arr.length-1][i]);
        return minSum;
    }
}