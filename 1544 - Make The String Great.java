class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && isBad(stack.peek(), ch))
                stack.pop();
            else
                stack.push(ch);
        }
        char[] result = new char[stack.size()];
        for(int i=result.length-1;i>=0;i--)
            result[i] = stack.pop();
        return new String(result);
    }
    
    public boolean isBad(char prev, char next){
        if(Character.isLowerCase(prev) && Character.isUpperCase(next) && (Character.toLowerCase(prev) == Character.toLowerCase(next)))
            return true;
        else if(Character.isUpperCase(prev) && Character.isLowerCase(next) && (Character.toLowerCase(prev) == Character.toLowerCase(next)))
            return true;
        else
            return false;
    }
}