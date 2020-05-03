class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int current = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            char n1 = i>=0?num1.charAt(i--):'0';
            char n2 = j>=0?num2.charAt(j--):'0';
            current += n1-'0'+n2-'0';
            sb.append(current%10);
            current /= 10;
        }
        if(current>0)
            sb.append(current);
        return sb.reverse().toString();
    }
}