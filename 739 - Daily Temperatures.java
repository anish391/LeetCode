class Solution {
    
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[T.length];
        for(int i=T.length-1;i>=0;i--){
            // Pop stack till current index is greater than TOS.
            while(!stack.isEmpty() && T[i]>=T[stack.peek()])
                stack.pop();
            result[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}