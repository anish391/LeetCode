class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<Character>();
        //Deque<Character> stack = new LinkedList<Character>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                char tos = stack.isEmpty() ? '#' : stack.pop();
                if(tos!=map.get(c))
                    return false;
            }
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}