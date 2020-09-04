class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24*60];
        for(String timePoint: timePoints){
            String[] time = timePoint.split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            if(mark[hour*60+min])
                return 0;
            mark[hour*60+min] = true;
        }
        int minimumDifference = Integer.MAX_VALUE;
        int firstPoint = Integer.MAX_VALUE;
        int lastPoint = Integer.MIN_VALUE;
        int prev = 0;
        for(int i=0;i<24*60;i++){
            if(mark[i]){
                if(firstPoint!=Integer.MAX_VALUE)
                    minimumDifference = Math.min(minimumDifference, i-prev);
                firstPoint = Math.min(firstPoint, i);
                lastPoint = Math.max(lastPoint, i);
                prev = i;
            }
        }
        minimumDifference = Math.min(minimumDifference, (24*60-lastPoint+firstPoint));
        return minimumDifference;
    }
}