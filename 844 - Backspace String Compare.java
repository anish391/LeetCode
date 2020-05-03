class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    
    public String build(String s){
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c!='#')
                stack.push(c);
            else if(!stack.isEmpty())
                stack.pop();
        }
        return String.valueOf(stack);
    }
}