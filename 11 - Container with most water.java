class Solution {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int area = Integer.MIN_VALUE;
        while(left<right){
            area = Math.max(area, (right-left)*Math.min(height[left],height[right]));
            if(height[left]<=height[right])
                left++;
            else if(height[left]>=height[right])
                right--;
        }
        return area;
    }
}