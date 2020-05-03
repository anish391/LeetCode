class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0)
            return true;
        Arrays.sort(intervals,(arr1, arr2)->arr1[0]-arr2[0]);
        //PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1])
                return false;
        }
        return true;
    }
}