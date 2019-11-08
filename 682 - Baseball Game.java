https://leetcode.com/problems/baseball-game/

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> valid = new Stack<Integer>();
        int sum = 0;
        for(String s: ops){
            if(s.equals("C")){
                int invalid = valid.pop();
                sum-=invalid;
            }
            else if(s.equals("D")){
                int dble = valid.peek();
                dble*=2;
                valid.push(dble);
                sum+=dble;
            }
            else if(s.equals("+")){
                int a = valid.pop();
                int b = valid.peek();
                valid.push(a);
                int plus = a+b;
                sum+=plus;
                valid.push(plus);
            }
            else{
                valid.push(Integer.parseInt(s));
                sum+=Integer.parseInt(s);
            }
        }
        return sum;
    }
}