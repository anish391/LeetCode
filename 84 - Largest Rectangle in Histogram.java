class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        int[] lesserLeft = new int[heights.length];
        int[] lesserRight = new int[heights.length];
        lesserLeft[0] = -1;
        lesserRight[lesserRight.length-1] = lesserRight.length;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<heights.length;i++){
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i])
                p = lesserLeft[p];
            lesserLeft[i] = p;
        }
        for(int i=heights.length-2;i>=0;i--){
            int p = i+1;
            while(p<heights.length && heights[p]>=heights[i])
                p = lesserRight[p];
            lesserRight[i] = p;
        }    
        for(int i=0;i<heights.length;i++)
            max = Math.max(max, heights[i]*(lesserRight[i]-lesserLeft[i]-1));
        return max;
    }
}