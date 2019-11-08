class Solution {
    public String removeDuplicates(String S) {
        if(S.length()==0)
            return S;
        Stack<Character> stack = new Stack<Character>();
        stack.push(S.charAt(0));
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<S.length();i++){
            if(!stack.isEmpty() && stack.peek()==S.charAt(i))
                stack.pop();
            else
                stack.push(S.charAt(i));
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}