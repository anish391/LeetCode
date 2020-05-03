class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arr1,arr2)->arr1[0]-arr2[0]);
        LinkedList<int[]> merged = new LinkedList();
        for(int[] interval: intervals){
            if(merged.size()==0 || merged.getLast()[1]<interval[0])
                merged.add(interval);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}