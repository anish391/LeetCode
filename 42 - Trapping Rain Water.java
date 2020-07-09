class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        for(int i=1;i<n-1;i++){
            // If column at current location is greater than left or right walls, water can't fill there
            int left = height[i];
            for(int j=0;j<i;j++)
                left = Math.max(left, height[j]);
            int right = height[i];
            for(int j=i+1;j<n;j++)
                right = Math.max(right, height[j]);
            // Water will only be filled till the minimum height of left or right wall.
            int waterHeight = Math.min(left, right);
            // If there's a column at the position, water can't fill there.
            result += waterHeight - height[i];
        }
        return result<0?0:result;
    }
}

// Stack solution
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        for(int right = 0; right<height.length; right++){
            while(!stack.isEmpty() && height[right]>height[stack.peek()]){
                // Bottom represents the size of column.
                int bottom = stack.pop();
                // If stack is empty, there are no elements to the left of bottom.
                if(stack.isEmpty())
                    break;
                int left = stack.peek();
                int breadthOfWater = right-left-1;
                int heightOfWater = Math.min(height[left], height[right]) - height[bottom];
                result+=breadthOfWater*heightOfWater;
            }
            stack.push(right);
        }
        return result;
    }
}

// 2 Pointer solution

class Solution {
    public int trap(int[] height) {
        if(height.length==0)
            return 0;
        int left=0, right=height.length-1;
        int leftMax = 0, rightMax=0;
        int result=0;
        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // As long as right wall is greater than left wall, water height depends on left wall.
            if(leftMax<rightMax){
                result+= Math.max(0, leftMax-height[left]);
                left++;
            }
            else{
                result+= Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return result<0?0:result;
    }
}