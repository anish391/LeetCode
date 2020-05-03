class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        for(int i: preorder){
            if(i<low)
                return false;
            while(!stack.isEmpty() && i>stack.peek())
                low = stack.pop();
            stack.push(i);
        }
        return true;
    }
}