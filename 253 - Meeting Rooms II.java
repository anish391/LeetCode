class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        int numberOfRooms = 1;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            if(!pq.isEmpty() && intervals[i][0]>=pq.peek())
                pq.poll();
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}