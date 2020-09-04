class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int[] heights = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    heights[j] = 0;
                else if(matrix[i][j]=='1')
                    heights[j]++;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] heights){
        int[] lesserLeft = new int[heights.length];
        int[] lesserRight = new int[heights.length];
        lesserLeft[0] = -1;
        lesserRight[lesserRight.length-1] = lesserRight.length;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<lesserLeft.length;i++){
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i])
                p = lesserLeft[p];
            lesserLeft[i] = p;
        }
        for(int i=lesserRight.length-2;i>=0;i--){
            int p=i+1;
            while(p<lesserRight.length && heights[p]>=heights[i])
                p = lesserRight[p];
            lesserRight[i] = p;
        }
        for(int i=0;i<heights.length;i++){
            max = Math.max(max, (lesserRight[i]-lesserLeft[i]-1)*heights[i]);
        }
        return max;
    }
}