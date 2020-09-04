class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int noOfStudents = 0;
        for(int i=0;i<n;i++){
            if(queryTime>=startTime[i] && queryTime<=endTime[i])
                noOfStudents++;
        }
        return noOfStudents;
    }
}