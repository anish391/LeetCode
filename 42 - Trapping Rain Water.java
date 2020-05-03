class Solution {
    public int trap(int[] height) {
        //int left = 0, right=0;
        int result = 0;
        int n = height.length;
        for(int i=1;i<n-1;i++){
            int left = height[i];
            for(int j=0;j<i;j++)
                left = Math.max(left, height[j]);
            int right = height[i];
            for(int j=i+1;j<n;j++)
                right = Math.max(right, height[j]);
            result+=Math.min(left,right)-height[i];
        }    
        return result<0?0:result;
    }
}