class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        int maxLen = 0;
        for(String s: input.split("\n")){
            int level = s.lastIndexOf("\t")+1; // Level of directory
            while(level+1<stack.size()) // If Level of directory is less than current stack size pop. Helps to backtrack.
                stack.pop();
            int length = stack.peek() + s.length() - level + 1;//Remove all tabs for backslash
            stack.push(length);// Push current length
            if(s.contains(".")){
                maxLen = Math.max(maxLen, length-1); // Compare maxLen, length-1 to comepensate for final backslash
            }
        }
        return maxLen;
    }
}