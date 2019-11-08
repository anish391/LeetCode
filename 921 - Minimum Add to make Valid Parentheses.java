class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack();
        int count = 0;
        for(char c: S.toCharArray()){
            if(c=='(')
                stack.push(c);
            else if(c==')' && !stack.isEmpty())
                stack.pop();
            else 
                count++;
        }
        return count+stack.size();
    }
}