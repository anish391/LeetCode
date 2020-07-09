class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while(index<s.length()){
            if(Character.isDigit(s.charAt(index))){
                int number = 0;
                while(index<s.length() && Character.isDigit(s.charAt(index))){
                    int digit = s.charAt(index)-'0';
                    number= number*10 + digit;
                    index++;
                }
                numberStack.add(number);
            }
            else if(s.charAt(index)=='['){
                stringStack.add(result);
                result = new StringBuilder();
                index++;
            }
            else if(s.charAt(index)==']'){
                int repeat = numberStack.pop();
                StringBuilder temp = stringStack.pop();
                for(int i=0;i<repeat;i++)
                    temp.append(result);
                result = temp;
                index++;
            }
            else{
                result.append(s.charAt(index++));
            }
        }
        return result.toString();
    }
}