class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Set<String> operators = new HashSet(Arrays.asList("+","-","*","/"));
        // operators.add("+");
        // operators.add("-");
        // operators.add("*");
        // operators.add("/");
        for(String token: tokens){
            if(stack.size()>=2 && operators.contains(token)){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluate(operand1, operand2, token);
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
    
    public int evaluate(int operand1, int operand2, String token){
        if(token.equals("+")){
            return operand1+operand2;
        }
        else if(token.equals("-")){
            return operand1-operand2;
        }
        else if(token.equals("*")){
            return operand1*operand2;
        }
        else if(token.equals("/")){
            return operand1/operand2;
        }
        else
            return Integer.MIN_VALUE;
    }
}