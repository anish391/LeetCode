//https://leetcode.com/problems/remove-outermost-parentheses/

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(char c: S.toCharArray()){
            if(c=='('){
                counter++;
                if(counter!=1){
                    sb.append(c);
                }
            }
            else if(c==')'){
                counter--;
                if(counter!=0){
                    sb.append(c);
                }
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }   
}